/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Cristi
 */
public class CustomCellRenderer {
    
    private final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

    public void AlternateColors(JTable table, int divisionSize, Color color1, Color color2) {
        table.setDefaultRenderer(Object.class, new TableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if ( (row/divisionSize) % 2 == 0) {
                    c.setBackground(color1);
                    c.setForeground(color2);
                } else {
                    c.setBackground(color2);
                    c.setForeground(color1);
                }
                return c;
            }

        });
    
    }
    
}