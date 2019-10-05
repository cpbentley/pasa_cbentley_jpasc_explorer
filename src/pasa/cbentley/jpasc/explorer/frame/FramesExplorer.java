package pasa.cbentley.jpasc.explorer.frame;

import pasa.cbentley.jpasc.explorer.ctx.PascExplorerCtx;

public class FramesExplorer {

   protected final PascExplorerCtx    pec;

   private FrameReferenceAbout        frameReferenceAbout;

   private FrameReferenceNoConnection frameReferenceCon;

   private FrameReferenceDaemonHelp   frameReferenceDaemon;

   private FrameReferenceExplorer     frameReferenceMain;

   private FrameReferenceAgreement    frameReferenceAgreement;

   private FrameReferenceConnecting   frameReferenceConnecting;

   public FramesExplorer(PascExplorerCtx pec) {
      this.pec = pec;
   }

   public void cmdShowAboutTab() {
      getFrameAbout().showFrame();
   }

   public FrameReferenceConnecting getFrameConnecting() {
      //add the about tab in a frame
      if (frameReferenceConnecting == null) {
         frameReferenceConnecting = new FrameReferenceConnecting(pec);
      }
      return frameReferenceConnecting;
   }

   public FrameReferenceAgreement getFrameAgreement() {
      //add the about tab in a frame
      if (frameReferenceAgreement == null) {
         frameReferenceAgreement = new FrameReferenceAgreement(pec);
      }
      return frameReferenceAgreement;
   }

   public FrameReferenceAbout getFrameAbout() {
      //add the about tab in a frame
      if (frameReferenceAbout == null) {
         frameReferenceAbout = new FrameReferenceAbout(pec);
      }
      return frameReferenceAbout;
   }

   public void cmdShowDaemonHelp() {
      //add the about tab in a frame
      getFrameDaemon().showFrame();
   }

   public FrameReferenceDaemonHelp getFrameDaemon() {
      if (frameReferenceDaemon == null) {
         frameReferenceDaemon = new FrameReferenceDaemonHelp(pec);
      }
      return frameReferenceDaemon;
   }

   public FrameReferenceExplorer getFrameMainWindow() {

      if (frameReferenceMain == null) {
         frameReferenceMain = new FrameReferenceExplorer(pec);
      }
      return frameReferenceMain;
   }

   public void cmdShowMainWindow() {
      getFrameMainWindow().showFrame();
   }

   public FrameReferenceNoConnection getFrameNoConnection() {
      //add the about tab in a frame
      if (frameReferenceCon == null) {
         frameReferenceCon = new FrameReferenceNoConnection(pec);
      }
      return frameReferenceCon;
   }

   public void cmdShowNoConnection() {
      getFrameNoConnection().showFrame();
   }
}
