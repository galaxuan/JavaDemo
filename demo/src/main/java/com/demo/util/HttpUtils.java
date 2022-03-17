package com.demo.util;

import com.alibaba.fastjson.JSON;
import com.demo.base.ErrorCode;
import com.demo.base.Message;
import com.demo.constant.Constants;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponentsBuilder;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpUtils {

    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static final String CHARSET = "UTF-8";
    /**
     * 连接池最大连接数
     */
    private static final Integer MAX_CONN_TOTAL = 500;
    /**
     * 单个路由最大连接数
     */
    private static final Integer MAX_CONN_ROUTE = 20;

    public static final String errorCode = " error code :";
    public static final String postUrlResult = "post url result:";

    private static final CloseableHttpClient httpClient;

    static {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(Constants.CONNECTION_TIMEOUT)
                .setSocketTimeout(Constants.SO_TIMEOUT).setConnectionRequestTimeout(Constants.CONN_REQ_TIMEOUT).build();

        httpClient = HttpClientBuilder.create().setRetryHandler(new DefaultHttpRequestRetryHandler(
        )).setDefaultRequestConfig(config)
                .setMaxConnTotal(MAX_CONN_TOTAL)
                .setMaxConnPerRoute(MAX_CONN_ROUTE)
                .build();
    }

    public static CloseableHttpClient getHttpClient() {
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create();
        ConnectionSocketFactory plainSf = new PlainConnectionSocketFactory();
        registryBuilder.register("http", plainSf);
        //指定信任密钥存储对象和连接套接字工厂
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            //信任任何链接
            TrustStrategy anyTrustStrategy = new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            };
            SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy).build();
            LayeredConnectionSocketFactory sslSf = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            registryBuilder.register("https", sslSf);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Registry<ConnectionSocketFactory> registry = registryBuilder.build();
        //设置连接管理器
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);
        //构建客户端
        return HttpClientBuilder.create().setConnectionManager(connManager).build();
    }


    public static String doGet(String url, Map<String, String> params) {
        return doGet(url, params, CHARSET);
    }

    public static String doPost(String url, Map<String, String> params) {
        return doPost(url, params, CHARSET);
    }

    /**
     * HTTP Get 获取内容
     *
     * @param url     请求的url地址 ?之前的地址
     * @param params  请求的参数
     * @param charset 编码格式
     * @return 页面内容
     */
    public static String doGet(String url, Map<String, String> params, String charset) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (params != null && !params.isEmpty()) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        uriBuilder.addParameter(entry.getKey(), value);
                    }
                }
            }
            if (logger.isDebugEnabled()) {
                logger.debug(" get url " + uriBuilder.build().toString());
            }
            HttpGet httpGet = new HttpGet(uriBuilder.build().toString());
            CloseableHttpResponse response = getHttpClient().execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                return JSON.toJSONString(new Message(ErrorCode.ERRORCODE_HTTP_GET, errorCode + statusCode));
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, charset);
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            System.err.println(url);
            logger.info(e.getMessage(), e);
        }
        return null;
    }


    /**
     * HTTP Get 参数已经转码
     *
     * @param url
     * @param params
     * @return
     */
    public static String doGetWithEncodingParam(String url, Map<String, String> params) {
        return doGetWithEncodingParam(url, params, CHARSET);
    }

    /**
     * HTTP Get 参数已经转码
     *
     * @param url     请求的url地址 ?之前的地址
     * @param params  请求的参数
     * @param charset 编码格式
     * @return 页面内容
     */
    public static String doGetWithEncodingParam(String url, Map<String, String> params, String charset) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        try {

            UriComponentsBuilder uriBuilder = UriComponentsBuilder
                    .fromHttpUrl(url);
            if (params != null && !params.isEmpty()) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        uriBuilder.queryParam(entry.getKey(), value);
                    }
                }
            }
            if (logger.isDebugEnabled()) {
                logger.debug(" get url " + uriBuilder.build().toString());
            }
            HttpGet httpGet = new HttpGet(uriBuilder.build().toString());
            CloseableHttpResponse response = getHttpClient().execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                return JSON.toJSONString(new Message(ErrorCode.ERRORCODE_HTTP_GET, errorCode + statusCode));
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, charset);
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            System.err.println(url);
            logger.info(e.getMessage(), e);
        }
        return null;
    }

    /**
     * HTTP Get 获取内容
     *
     * @param url     请求的url地址 ?之前的地址
     * @param params  请求的参数
     * @param charset 编码格式
     * @return 页面内容
     */
    public static String doGetWithHeader(String url, Map<String, String> params, String charset, Map<String, String> headers) {
        return doGetWithHeader(url, params, charset, headers, null);
    }

    /**
     * HTTP Get 获取内容
     *
     * @param url     请求的url地址 ?之前的地址
     * @param params  请求的参数
     * @param charset 编码格式
     * @param config  请求配置覆盖默认配置
     * @return 页面内容
     */
    public static String doGetWithHeader(String url, Map<String, String> params, String charset, Map<String, String> headers, RequestConfig config) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (params != null && !params.isEmpty()) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        uriBuilder.addParameter(entry.getKey(), value);
                    }
                }
            }
            logger.info(" get url " + uriBuilder.build().toString());
            HttpGet httpGet = new HttpGet(uriBuilder.build().toString());
            if (config != null) {
                httpGet.setConfig(config);
            }

            if (headers != null && !headers.isEmpty()) {
                for (String key : headers.keySet()) {
                    httpGet.addHeader(key, headers.get(key));
                }
            }

            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                return JSON.toJSONString(new Message(ErrorCode.ERRORCODE_HTTP_GET, errorCode + statusCode));
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, charset);
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            System.err.println(url);
            logger.info(e.getMessage(), e);
        }
        return null;
    }

    /**
     * HTTP Post 获取内容
     *
     * @param url     请求的url地址 ?之前的地址
     * @param params  请求的参数
     * @param charset 编码格式
     * @return 页面内容
     */
    public static String doPost(String url, Map<String, String> params, String charset) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        try {
            List<NameValuePair> pairs = null;
            if (params != null && !params.isEmpty()) {
                pairs = new ArrayList<NameValuePair>(params.size());
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        pairs.add(new BasicNameValuePair(entry.getKey(), value));
                        logger.debug(entry.getKey() + "=" + value);
                    }
                }
                logger.debug("post url: " + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset)));
            }
            HttpPost httpPost = new HttpPost(url);
            if (pairs != null && pairs.size() > 0) {
                httpPost.setEntity(new UrlEncodedFormEntity(pairs, charset));
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpPost.abort();
                return JSON.toJSONString(new Message(ErrorCode.ERRORCODE_HTTP_POST, errorCode + statusCode));
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, charset);
            }
            EntityUtils.consume(entity);
            response.close();
            logger.debug(postUrlResult + result);
            return result;
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            return null;
        }
    }

    public static final String CONTENT_TYPE_TEXT_JSON = "text/json";

    public static final String APPLICATION_JSON = "application/json";

    /**
     * HTTP Post 获取内容 application/json
     *
     * @param url    请求的url地址
     * @param params 请求的参数
     * @return 页面内容
     */
    public static String doPostWithJson(String url, Map<String, Object> params) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
            if (params != null && params.size() > 0) {
                String jsonString = JSON.toJSONString(params);
//                String encoderJson = URLEncoder.encode(jsonString, CHARSET);
                StringEntity se = new StringEntity(jsonString);
                se.setContentType(CONTENT_TYPE_TEXT_JSON);
                se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
                httpPost.setEntity(se);
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpPost.abort();
                return JSON.toJSONString(new Message(ErrorCode.ERRORCODE_HTTP_POST, errorCode + statusCode));
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, CHARSET);
            }
            EntityUtils.consume(entity);
            response.close();
            logger.debug(postUrlResult + result);
            return result;
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            return null;
        }
    }

    /**
     * HTTP Post 获取内容 application/json
     *
     * @param url     请求的url地址
     * @param params  请求的参数
     * @param headers 请求头
     * @return 页面内容
     */
    public static String doPostWithJsonAndHeader(String url, Map<String, Object> params, Map<String, String> headers) throws Exception {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        HttpPost httpPost = null;
        CloseableHttpResponse response = null;
        try {
            httpPost = new HttpPost(url);
            httpPost.setHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
            if (params != null && params.size() > 0) {
                String jsonString = JSON.toJSONString(params);
//                String encoderJson = URLEncoder.encode(jsonString, CHARSET);
                StringEntity se = new StringEntity(jsonString);
                se.setContentType(CONTENT_TYPE_TEXT_JSON);
                se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
                httpPost.setEntity(se);
            }
            if (headers != null) {
                Set<Map.Entry<String, String>> headerEntries = headers.entrySet();
                for (Map.Entry<String, String> head : headerEntries) {
                    httpPost.setHeader(head.getKey(), head.getValue());
                }
            }
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpPost.abort();
                return JSON.toJSONString(new Message(ErrorCode.ERRORCODE_HTTP_POST, errorCode + statusCode));
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, CHARSET);
            }
            EntityUtils.consume(entity);
            response.close();
            logger.debug(postUrlResult + result);
            return result;
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpPost != null) {
                httpPost.abort();
            }
        }
    }
}
