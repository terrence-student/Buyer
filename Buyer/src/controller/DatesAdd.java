package controller;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.*;
import java.util.function.Consumer;

public class DatesAdd extends JPanel {

    private Consumer<String> onDateSelected; // 回調變量
    private String[] weekName = new String[]{"一", "二", "三", "四", "五", "六", "日"};
    private LocalDate focusDate;
    private JLabel focusDayJLabel;
    private JPanel dayJPanel;
    private JLabel viewJLabel;
    private JLabel upJLabel;
    private JLabel downJLabel;
    private JLabel head;
    private List<JLabel> dayJLabel = new ArrayList<>(49);

    // 构造函数增加一个 Consumer 参数
    public DatesAdd(Consumer<String> onDateSelected) {
        this.onDateSelected = onDateSelected;
        this.setLayout(null);
        initializeComponents();
    }

    private void initializeComponents() {
        // 初始化日期选择界面
        LocalDate currentDate = LocalDate.now();
        focusDate = currentDate;

        head = new JLabel();
        head.setBounds(0, 0, 300, 50);

        int year = currentDate.getYear() - 1911;
        int month = currentDate.getMonthValue();
        int dayOfMonth = currentDate.getDayOfMonth();
        String dayOfWeek = currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());

        JLabel nowDateJLabel = new JLabel(String.format("中華民國%s年%s月%s日，%s", year, month, dayOfMonth, dayOfWeek));
        nowDateJLabel.setBounds(0, 0, 300, 20);
        nowDateJLabel.setHorizontalAlignment(JLabel.CENTER);
        nowDateJLabel.setOpaque(true);
        nowDateJLabel.setBackground(Color.LIGHT_GRAY);

        viewJLabel = new JLabel(String.format("中華民國%s年%s月", year, month));
        viewJLabel.setBounds(15, 22, 170, 24);
        viewJLabel.setOpaque(true);

        upJLabel = new JLabel("㊤");
        upJLabel.setBounds(195, 22, 40, 24);
        upJLabel.setOpaque(true);
        upJLabel.setHorizontalAlignment(JLabel.CENTER);

        downJLabel = new JLabel("㊦");
        downJLabel.setBounds(245, 22, 40, 24);
        downJLabel.setOpaque(true);
        downJLabel.setHorizontalAlignment(JLabel.CENTER);

        // 增加上/下月按钮点击事件
        upJLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                focusDate = focusDate.minusMonths(1);  // 切换到上个月
                refreshDayJPanel();  // 刷新日期面板
                DatesAdd.this.repaint();  // 重新绘制面板
            }
        });

        downJLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                focusDate = focusDate.plusMonths(1);  // 切换到下个月
                refreshDayJPanel();  // 刷新日期面板
                DatesAdd.this.repaint();  // 重新绘制面板
            }
        });

        head.add(nowDateJLabel);
        head.add(upJLabel);
        head.add(downJLabel);
        head.add(viewJLabel);
        head.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.gray));

        this.add(head);

        // 初始化日期面板
        initializeDatePanels();
        refreshDayJPanel(); // 初始显示日期
    }

    private void initializeDatePanels() {
        dayJPanel = new JPanel();
        dayJPanel.setLayout(new GridLayout(7, 7));
        dayJPanel.setBounds(0, 50, 300, 212);
        dayJPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        for (int i = 0; i < 49; i++) {
            JLabel jLabel = new JLabel();
            jLabel.setOpaque(true);
            jLabel.setBackground(Color.white);
            jLabel.setHorizontalAlignment(JLabel.CENTER);

            if (i < 7) {
                jLabel.setText(weekName[i]);  // 设置星期名称
            } else {
                jLabel.addMouseListener(new MouseUpListener(jLabel) {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (jLabel.getText() != null && jLabel.getText().length() > 0) {
                            focusDayJLabel.setBorder(null);  // 清除之前选中的边框
                            focusDate = focusDate.withDayOfMonth(Integer.valueOf(jLabel.getText()));  // 更新选中的日期
                            jLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN));  // 高亮选中的日期
                            focusDayJLabel = jLabel;
                            notifyDateSelected();  // 通知日期选择事件
                        }
                    }
                });
            }

            dayJPanel.add(jLabel);
            dayJLabel.add(jLabel);
        }

        this.add(dayJPanel);
    }

    public void refreshDayJPanel() {
        viewJLabel.setText(String.format("中華民國%s年%s月", focusDate.getYear() - 1911, focusDate.getMonthValue()));

        int dayLength = focusDate.lengthOfMonth();
        LocalDate dayOfStart = LocalDate.of(focusDate.getYear(), focusDate.getMonthValue(), 1);
        int weekOfStart = dayOfStart.getDayOfWeek().getValue();

        if (weekOfStart == 7) weekOfStart = 0;

        for (int i = 7; i < 49; i++) {
            JLabel jLabel = dayJLabel.get(i);
            jLabel.setText("");
            jLabel.setBorder(null);

            if (i >= weekOfStart + 7 && i < dayLength + weekOfStart + 7) {
                jLabel.setText(String.valueOf(i - weekOfStart - 6));

                if (focusDate.getDayOfMonth() == i - weekOfStart - 6) {
                    jLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                    focusDayJLabel = jLabel;
                }
            }
        }
    }

    // 通知日期选择完成时回调
    void notifyDateSelected() {
        String selectedDate = getFormattedDate();
        if (onDateSelected != null) {
            onDateSelected.accept(selectedDate);  // 通过回调传递选中的日期
        }
    }

    // 格式化日期输出
    public String getFormattedDate() {
        int year = focusDate.getYear() - 1911;  // 将西元年转换为民国年
        int month = focusDate.getMonthValue();
        int day = focusDate.getDayOfMonth();
        return String.format("中華民國 %d 年 %d 月 %d 日", year, month, day);
    }
    
 // 格式化日期输出給Account
    public List<Integer> getFormattedDateToAccountant() {
        int[] daysAdd = new int[3];
        int year = focusDate.getYear() - 1911;  // 将西元年转换为民国年
        int month = focusDate.getMonthValue();
        int day = focusDate.getDayOfMonth();
        daysAdd[0] = year;
        daysAdd[1] = month;
        daysAdd[2] = day;

        // Convert int[] to List<Integer>
        List<Integer> daysAddList = new ArrayList<>();
        for (int value : daysAdd) {
            daysAddList.add(value);
        }

        return daysAddList;
    
}


    // 内部抽象类用于处理鼠标点击事件
    abstract class MouseUpListener extends MouseAdapter {
        private JLabel jLabel;

        public MouseUpListener(JLabel jLabel) {
            this.jLabel = jLabel;
        }
    }
}
