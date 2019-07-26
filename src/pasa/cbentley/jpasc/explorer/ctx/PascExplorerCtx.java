/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.explorer.ctx;

import pasa.cbentley.core.src4.ctx.ACtx;
import pasa.cbentley.jpasc.explorer.menu.MenuBarFactoryExplorer;
import pasa.cbentley.jpasc.explorer.panel.TabExplorerAbout;
import pasa.cbentley.jpasc.explorer.run.RunJPascExplorer;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.swing.ctx.SwingCtx;

public class PascExplorerCtx extends ACtx {

   protected final PascalSwingCtx psc;

   private RunJPascExplorer       runner;

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
      //add the about tab 
      TabExplorerAbout about = new TabExplorerAbout(this);
      psc.getSwingCtx().showInNewFrame(about);
   }

   public void setRunner(RunJPascExplorer runner) {
      this.runner = runner;
   }
}
