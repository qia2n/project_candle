package utils;
import com.dam.Order;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public final class OrderUtils {
    private OrderUtils() {}

    public static String formatOrderDate(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(calendar.getTime());
    }

    public static boolean validateOrder(Order order) {
        return order != null &&
                order.getCodeOrder() != null &&
                order.getTotalPrice() > 0 &&
                order.getOrderDate() != null &&
                order.getClient() != null;
    }


    public static String generateOrderSummary(Order order) {
        if (!validateOrder(order)) return "Invalid Order";

        return String.format(
                order.getCodeOrder(),
                order.getClient().getName(),
                order.getTotalPrice()
        );
    }
}
