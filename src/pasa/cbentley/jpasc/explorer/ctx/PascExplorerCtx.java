/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.ctx;

import pasa.cbentley.core.src4.ctx.ACtx;
import pasa.cbentley.jpasc.explorer.menu.MenuBarFactoryExplorer;
import pasa.cbentley.jpasc.explorer.panel.about.TabsExplorerAboutRoot;
import pasa.cbentley.jpasc.explorer.run.RunJPascExplorer;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.swing.ctx.SwingCtx;
import pasa.cbentley.swing.imytab.FrameIMyTab;
import pasa.cbentley.swing.imytab.FrameReference;

public class PascExplorerCtx extends ACtx {

   protected final PascalSwingCtx psc;

   private RunJPascExplorer       runner;

   private String                 version;

   private FrameReference         frameReferenceAbout;

   public PascExplorerCtx(PascalSwingCtx psc) {
      super(psc.getUCtx());
      this.psc = psc;
      SwingCtx sc = psc.getSwingCtx();
      MenuBarFactoryExplorer menuFactory = new MenuBarFactoryExplorer(this);
      sc.setTabMenuBarFactory(menuFactory);
   }

   public PascalSwingCtx getPascalSwingCtx() {
      return psc;
   }

   public SwingCtx getSwingCtx() {
      return psc.getSwingCtx();
   }

   public void cmdShowAboutTab() {
      //add the about tab in a frame
      if (frameReferenceAbout == null) {
         frameReferenceAbout = new FrameReference(psc.getSwingCtx());
      }
      if (frameReferenceAbout.getFrame() == null) {
         TabsExplorerAboutRoot about = new TabsExplorerAboutRoot(this);
         FrameIMyTab f = new FrameIMyTab(about); //deal with tab dispose auto
         
         //so the reference to be set to null when closed
         f.setFrameReference(frameReferenceAbout);
         
         //we want the frame to be computed based on screen currently used
         psc.getSwingCtx().showInNewFrame(f, 0.6f, 0.9f);
      } else {
         frameReferenceAbout.getFrame().setVisible(true);
      }

   }

   public void setRunner(RunJPascExplorer runner) {
      this.runner = runner;
   }

   public String getVersion() {
      return version;
   }

   public void setVersion(String version) {
      this.version = version;
   }
}
