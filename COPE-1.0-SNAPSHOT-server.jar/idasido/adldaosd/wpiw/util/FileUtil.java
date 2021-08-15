/*    */ package idasido.adldaosd.wpiw.util;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Path;
/*    */ import java.nio.file.Paths;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ import java.util.stream.Collectors;
/*    */ import java.util.stream.Stream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class FileUtil
/*    */ {
/*    */   public static List<File> getFiles(String dir) {
/*    */     
/* 20 */     try { Stream<Path> paths = Files.walk(Paths.get(dir, new String[0]), new java.nio.file.FileVisitOption[0]); 
/* 21 */       try { List<File> list = (List)paths.filter(x$0 -> Files.isRegularFile(x$0, new java.nio.file.LinkOption[0])).map(Path::toFile).collect(Collectors.toList());
/* 22 */         if (paths != null) paths.close();  return list; } catch (Throwable throwable) { if (paths != null) try { paths.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception exception)
/* 23 */     { return new ArrayList<>(); }
/*    */   
/*    */   }
/*    */   
/*    */   public static Optional<File> getFile(String name) {
/* 28 */     return Optional.of(new File(name));
/*    */   }
/*    */ 
/*    */   
/*    */   public static String randomString() {
/* 33 */     String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
/* 34 */     StringBuilder sb = new StringBuilder(20);
/* 35 */     for (int i = 0; i < 20; i++) {
/* 36 */       int index = (int)(AlphaNumericString.length() * Math.random());
/* 37 */       sb.append(AlphaNumericString.charAt(index));
/*    */     } 
/* 39 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpi\\util\FileUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */