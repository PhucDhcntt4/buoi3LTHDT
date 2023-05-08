
// import java.text.NumberFormat;
// import java.text.SimpleDateFormat;
// import java.util.Calendar;
// import java.util.Date;
// import java.util.Locale;

// class Orther{

// 	private int maHD,maSP,soluong,stt;
//     private String tenhang;
//     private double dongia;
//     private Date ngaylap;

//  public ThucPham(int stt,int maHD,int maSP,int soluong,String tenhang, double dongia, Date ngaylap) {
        
//         this.stt = stt;
//         this.maHD = maHD;
//         this.maSP = maSP;
//         this.soluong = soluong;
//         this.tenhang = tenhang;
//         this.dongia = dongia;
//         this.ngaylap = ngaylap;
        
//     }
 
//  public int getStt() {
//         return stt;
//     }

//     public void setStt(int stt) {
//         this.stt = stt;
//     }
//    public int getMaHD() {
//         return maHD;
//     }

//     public void setMaHD(int maHD) {
//         this.maHD = maHD;
//     }

//     public int getMaSP() {
//         return maSP;
//     }

//     public void setMaSP(int maSP) {
//         this.maSP = maSP;
//     }

//     public String getTenhang() {
//         return tenhang;
//     }

//      public int getSoluong() {
//         return soluong;
//     }

//     public void setSoluong(int soluong) {
//         this.soluong = soluong;
//     }

//     public void setTenhang(String tenhang) {
//         this.tenhang = tenhang;
//     }

//     public double getDongia() {
//         return dongia;
//     }

//     public void setDongia(double dongia) {
//         this.dongia = dongia;
//     }

//     public Date getNgaylap() {
//         return ngaylap;
//     }

//     public void setNgaylap(Date ngaylap) {
//         this.ngaylap = ngaylap;
//     }

    
//      @Override
    
//     public String toString() {
        
//         Locale localeVN = new Locale("vi", "VN");
//         NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
//         String str = numberFormat.format(dongia);
  
//         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//         String str1 = simpleDateFormat.format(ngaylap);

//         return "Ma HD:"+maHD+
//         		"ngay lap hoa don:"+ngaylap+
//         		"STT" + stt+ "Ma SP" + 
//         		""


// 	 public double thanhtien(){
//      	double tien;
//      	tien = dongia*soluong;
//     }

//     }
 
//     //Khởi tạo phương thức để nhập năm tháng ngày sản xuất
//     public void setNSX(int year, int month, int day) {
//         Calendar calendar = Calendar.getInstance();
//         calendar.set(year, month - 1, day);
//         this.nSX = calendar.getTime();
//     }
// }

import java.time.LocalDate;

class Product {
  private String description;
  private String productID;
  private double price;
  public Product() {}
  public Product(String id, String desc, double price) {
    this.productID = id;
    this.description = desc;
    this.price = price;
  }
  public double calcTotalPrice(int quantity) {
    return this.price * quantity;
  }
  public String toString() {

  	
    return String.format("%20s %20s %20s", productID, description, price);
  }
  public String getDescription() {
    return description;
  }
  public String getProductID() {
    return productID;
  }
  public double getPrice() {
    return price;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public void setProductID(String productID) {
    this.productID = productID;
  }
  public void setPrice(double price) {
    this.price = price;
  }
}

class Order {
  private int orderID;
  private LocalDate orderDate;
  private OrderDetail[] lineItems;
  private int count;
  public Order(int orderID, LocalDate orderDate) {
    this.orderID = orderID;
    this.orderDate = orderDate;
    this.lineItems = new OrderDetail[10];
    this.count = 0;
  }
  public int getOrderID() {
    return orderID;
  }
  public LocalDate getOrderDate() {
    return orderDate;
  }
  public void setOrderDate(LocalDate orderDate) {
    this.orderDate = orderDate;
  }
  public OrderDetail[] getLineItems() {
    return lineItems;
  }
  public void addLineItem(Product p, int quantity) {
    lineItems[count++] = new OrderDetail(p, quantity);
  }
  public double calcTotalCharge() {
    double total = 0;
    for (int i = 0; i < count; i++) {
      total += lineItems[i].calcTotalPrice();
    }
    return total;
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Order ").append(orderID).append(" (").append(orderDate).append("):\n");
    for (int i = 0; i < count; i++) {
      sb.append("\t").append(lineItems[i]).append("\n");
    }
    sb.append("Total charge: ").append(calcTotalCharge());
    return sb.toString();
  }
}

class OrderDetail {
  private Product product;
  private int quantity;
  public OrderDetail(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }
  public double calcTotalPrice() {
    return product.calcTotalPrice(quantity);
  }
  public String toString() {
    return String.format("%20s %20s %20s", product, quantity, calcTotalPrice());
  }
  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}

 public class bai1 {
  public static void main(String[] args) {

    Product p1 = new Product("sp4", "Nuoc tuong", 800);
    Product p2 = new Product("sp1", "Gao", 1800);
    Product p3 = new Product("sp3", "Duong", 1000);
    Product p4 = new Product("sp1", "Gao", 1800);
    Order o1 = new Order(1, LocalDate.now());
    o1.addLineItem(p1, 10);
    o1.addLineItem(p2, 5);
    o1.addLineItem(p3, 1);
    o1.addLineItem(p4, 1);
    System.out.println(o1.toString());
  }
}
