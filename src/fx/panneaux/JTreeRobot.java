package fx.panneaux;

import fx.programme.instructions.Instruction;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author yvan
 */
public class JTreeRobot extends JTree {

    private static final long serialVersionUID = 1L;

    private int memX = -1, memY = -1;
    private Instruction noeudSelectionné;

    public JTreeRobot(DefaultTreeModel modele) {
        super(modele);

        DefaultTreeCellRenderer dtcr = new DefaultTreeCellRenderer() {
            private static final long serialVersionUID = 1L;

            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
                if (((Instruction) value).getIcon() != null) {
                    setIcon(((Instruction) value).getIcon());
                }
                return this;
            }
        };

        dtcr.setLeafIcon(null);
        setCellRenderer(dtcr);

        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                try {
                    memX = me.getX();
                    memY = me.getY();
                    // ####  noeudSelectionné = (NoeudProgramme) getPathForLocation(memX, memY).getLastPathComponent();
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                } catch (Exception ex) {
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                /* ####
                try {
                    if (memX != me.getX() && memY != me.getY()) {
                         NoeudProgramme noeud = (NoeudProgramme) getPathForLocation(me.getX(), me.getY()).getLastPathComponent();
                         NoeudProgramme parent = (NoeudProgramme) noeud.getParent();
                        int i = parent.getIndex(noeud);
                        if (me.isControlDown()) {
                            parent.insert(noeudSelectionné.clone(), i);
                        } else {
                            parent.insert(noeudSelectionné, i);
                        }
                        updateUI();
                    }
                } catch (Exception ex) {
                } finally {
                    noeudSelectionné = null;
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    memX = -1;
                    memY = -1;
                }
#### */
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
    }
}
