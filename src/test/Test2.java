package test;
import java.io.*;
import java.util.*;

class Order {
    String customerName;
    String product;
    int quantity;
    double price;
    Date orderDate;

    public Order(String customerName, String product, int quantity, double price, Date orderDate) {
        this.customerName = customerName;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "고객: " + customerName + ", 상품: " + product + ", 수량: " + quantity + ", 가격: " + price + ", 주문 날짜: " + orderDate;
    }
}

public class Test2 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Order> orders = new ArrayList<>();
    private static final String FILE_NAME = "order.txt";

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. 상품 주문하기");
            System.out.println("2. 전체 주문 이력보기");
            System.out.println("3. 고객별 주문 이력 보기");
            System.out.println("4. 특정 날짜에 들어온 주문 이력보기");
            System.out.println("5. 끝내기");
            System.out.print("옵션을 선택하세요: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    showAllOrders();
                    break;
                case 3:
                    showOrdersByCustomer();
                    break;
                case 4:
                    showOrdersByDate();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void placeOrder() {
        System.out.print("고객 이름: ");
        String customerName = scanner.nextLine();
        
        System.out.print("상품명: ");
        String product = scanner.nextLine();
        
        System.out.print("수량: ");
        int quantity = scanner.nextInt();
        
        System.out.print("가격: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        
        Order order = new Order(customerName, product, quantity, price, new Date());
        orders.add(order);
        saveOrderToFile(order);
        System.out.println("주문이 완료되었습니다!");
    }

    private static void saveOrderToFile(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(order.customerName + "," + order.product + "," + order.quantity + "," + order.price + "," + order.orderDate + "\n");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류 발생: " + e.getMessage());
        }
    }

    private static void showAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("주문 이력이 없습니다.");
        } else {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    private static void showOrdersByCustomer() {
        System.out.print("고객 이름을 입력하세요: ");
        String customerName = scanner.nextLine();
        boolean found = false;
        
        for (Order order : orders) {
            if (order.customerName.equalsIgnoreCase(customerName)) {
                System.out.println(order);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("해당 고객의 주문 이력이 없습니다.");
        }
    }

    private static void showOrdersByDate() {
        System.out.print("특정 날짜(yyyy-MM-dd)를 입력하세요: ");
        String inputDate = scanner.nextLine();
        boolean found = false;
        
        for (Order order : orders) {
            String orderDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(order.orderDate);
            if (orderDate.equals(inputDate)) {
                System.out.println(order);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("해당 날짜의 주문 이력이 없습니다.");
        }
    }
}
