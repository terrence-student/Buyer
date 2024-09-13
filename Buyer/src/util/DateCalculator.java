package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DateCalculator {

    // 方法：計算應付款日
    public static String calculatePaymentDate(String rocDate, String paytype) {
        // 解析民國日期格式
        Pattern pattern = Pattern.compile("中華民國\\s*(\\d+)\\s*年\\s*(\\d+)\\s*月\\s*(\\d+)\\s*日");
        Matcher matcher = pattern.matcher(rocDate);

        if (matcher.matches()) {
            // 解析出民國年、月、日
            int rocYear = Integer.parseInt(matcher.group(1));  // 民國年
            int month = Integer.parseInt(matcher.group(2));    // 月
            int day = Integer.parseInt(matcher.group(3));      // 日

            // 將民國年轉換為西元年
            int year = rocYear + 1911;

            // 當前日期
            LocalDate currentDate = LocalDate.of(year, month, day);
            LocalDate billingDate;
            int days = 0; // 根據付款類型計算天數

            // 根據 paytype 設定不同的結帳條件
            switch (paytype) {
                case "A001":
                    // 當月結30天
                    billingDate = currentDate.withDayOfMonth(25); // 當月25日結帳
                    days = 30;
                    break;
                case "A002":
                    // 當月結60天
                    billingDate = currentDate.withDayOfMonth(25); // 當月25日結帳
                    days = 60;
                    break;
                case "A003":
                    // 次月結30天
                    billingDate = currentDate.plusMonths(1).withDayOfMonth(25); // 次月25日結帳
                    days = 30;
                    break;
                case "A004":
                    // 次月結60天
                    billingDate = currentDate.plusMonths(1).withDayOfMonth(25); // 次月25日結帳
                    days = 60;
                    break;
                case "A005":
                    // 次月結90天
                    billingDate = currentDate.plusMonths(1).withDayOfMonth(25); // 次月25日結帳
                    days = 90;
                    break;
               
                
                default:
                    return "不支持的付款類型";
            }

            // 從結帳日開始，計算相應的天數
            LocalDate dueDate = billingDate.plusDays(days);

            // 如果計算結果超過當月5日，則應付款日推至下個月5日
            LocalDate paymentDate;
            if (dueDate.getDayOfMonth() > 5) {
                paymentDate = dueDate.withDayOfMonth(5).plusMonths(1);
            } else {
                paymentDate = dueDate.withDayOfMonth(5);
            }

            // 將結果轉為民國格式並返回
            return String.format("民國 %d 年 %d 月 %d 日", paymentDate.getYear() - 1911, paymentDate.getMonthValue(), paymentDate.getDayOfMonth());
        } else {
            return "日期格式不正確，請輸入格式為: 中華民國 xxx 年 xx 月 xx 日";
        }
    }
    
    public static void updateLabelWithTime(JLabel label) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Taipei"));
        // 使用24小時制的 "HH" 來顯示時間
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss a");
        String formattedTime = now.format(formatter);

        // 分割時間和上午/下午部分
        String[] parts = formattedTime.split(" ");
        
        if (parts.length < 2) {
            label.setText("時間格式錯誤");
            return;
        }

        // 判斷是上午還是下午
        String period = parts[1].equalsIgnoreCase("AM") ? "上午" : "下午";
        // 將時間部分拼接為 "上午" 或 "下午" + 時間
        String time = period + " " + parts[0];
        
        // 更新 JLabel 的顯示內容
        label.setText(time);
    }
    
    
    
    
    public static void main(String[] args) {
        
        String rocDate = "aa";
        System.out.println(calculatePaymentDate(rocDate, "A006"));
        
     
        JLabel testLabel = new JLabel(); // 假設這個 JLabel 已經加到 GUI 上
        updateLabelWithTime(testLabel);
        System.out.println(testLabel.getText()); // 印出當前時間
        
    }
}
