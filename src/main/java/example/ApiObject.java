package example;

public class ApiObject {
    private int statusCode;
    private String executedVersion;
    private String topicArn;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        statusCode = statusCode;
    }

    public String getExecutedVersion() {
        return executedVersion;
    }

    public void setExecutedVersion(String executedVersion) {
        executedVersion = executedVersion;
    }

    public String getTopicArn() {
        return topicArn;
    }

    public void setTopicArn(String topicArn) {
        this.topicArn = topicArn;
    }

    @Override
    public String toString() {
        return "ApiObject{" +
                "StatusCode=" + statusCode +
                ", ExecutedVersion='" + executedVersion + '\'' +
                ", topicArn='" + topicArn + '\'' +
                '}';
    }
}
