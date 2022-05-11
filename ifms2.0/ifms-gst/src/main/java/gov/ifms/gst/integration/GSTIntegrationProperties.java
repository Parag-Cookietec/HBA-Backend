package gov.ifms.gst.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GSTIntegrationProperties {

    @Value( "${gst.integration.api.client.id}" )
    private String clientId;

    @Value( "${gst.integration.api.client.secret}" )
    private String clientSecret;

    @Value( "${gst.integration.api.app_key}" )
    private String appKey;

    @Value( "${gst.integration.api.username}" )
    private String username;

    @Value( "${gst.integration.api.password}" )
    private String password;

    @Value( "${gst.integration.api.url}" )
    private String url;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
