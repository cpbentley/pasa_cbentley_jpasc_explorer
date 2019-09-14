package pasa.cbentley.jpasc.explorer.menu;

import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_P;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import pasa.cbentley.core.src4.logging.ITechLvl;
import pasa.cbentley.jpasc.pcore.tools.PkNamesStore;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.swing.menu.MenuDebug;
import pasa.cbentley.swing.widgets.b.BMenuItem;

public class MenuDebugExplorer extends MenuDebug {

   private BMenuItem              itemToStringPkStore;

   protected final PascalSwingCtx psc;

   public MenuDebugExplorer(PascalSwingCtx psc) {
      super(psc.getSwingCtx());
      this.psc = psc;
   }

   public void actionPerformed(ActionEvent e) {
      super.actionPerformed(e);
      Object src = e.getSource();
      if (src == itemToStringPkStore) {
         PkNamesStore store = psc.getPCtx().getPkNameStore();
         //#debug
         sc.toDLog().pAlways("Debug", store, MenuDebugExplorer.class, "actionPerformed", ITechLvl.LVL_08_INFO, false);

      }
   }

   protected void initMenu() {
      super.initMenu();

      itemToStringPkStore = new BMenuItem(sc, this, "menu.debug.tostring.pkstore");
      itemToStringPkStore.setMnemonic(VK_P);
      itemToStringPkStore.setAccelerator(KeyStroke.getKeyStroke(VK_A, modCtrlAltShift));

      this.addSeparator();
      this.add(itemToStringPkStore);
   }

}
