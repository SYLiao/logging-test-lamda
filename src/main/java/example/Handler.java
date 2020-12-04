package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import com.google.gson.reflect.TypeToken;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

// Handler value: example.Handler
public class Handler implements RequestHandler<Object, String>{
  Gson gson = new GsonBuilder().setPrettyPrinting().create();
  @Override
  public String handleRequest(Object event, Context context)
  {
    LambdaLogger logger = context.getLogger();
    String response = new String("200 OK");
    // log execution details
    logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
    logger.log("CONTEXT: " + gson.toJson(context));
    // process event
    logger.log("EVENT: " + gson.toJson(event));
    logger.log("EVENT TYPE: " + event.getClass().toString());
    logger.log(event.getClass().getName());

    String jsonEvent = gson.toJson(event);
    Map<String, Object> json = gson.fromJson(jsonEvent, new TypeToken<HashMap<String, Object>>(){}.getType());
    String body = gson.toJson(json.get("body"));
    logger.log(body);
    body = body.replace("\\n", "").replace("\\", "");
    body = body.substring(1, body.length() - 1);
    String str = "test Jenkins";
    logger.log(body);
    logger.log(str);
    ApiObject bodyMap = gson.fromJson(body, ApiObject.class);
    logger.log(bodyMap.toString());
    return jsonEvent;

//    Map<String, String> event1 = (Map<String, String>) ((Map) event).get("body");
//
//    SnsClient snsClient = SnsClient.builder().region(Region.US_EAST_2).build();
//
//    try {
//      PublishRequest request = PublishRequest.builder()
//              .message(response)
//              .topicArn(event1.get("topicArn"))
//              .build();
//
//      PublishResponse result = snsClient.publish(request);
//      System.out.println(result.messageId() + " Message sent. Status was " + result.sdkHttpResponse().statusCode());
//
//    } catch (SnsException e) {
//      System.err.println(e.awsErrorDetails().errorMessage());
//      System.exit(1);
//    } finally {
//      snsClient.close();
//    }

//    return response;
  }
}