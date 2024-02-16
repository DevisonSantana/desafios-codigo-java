import java.util.Scanner;

/** Classe base para descontos (aberto para extensões) */
class Discount {
  public double calculateDiscount(double originalValue) {
    return originalValue; // No default discount
  }
}

final class StudentDiscount extends Discount {
  @Override
  public double calculateDiscount(double originalValue) {
    return originalValue * 0.9; // 10% de desconto para estudantes
  }
}

final class MembershipDiscount extends Discount {
  @Override
  public double calculateDiscount(double originalValue) {
    return originalValue * 0.85; // 15% de desconto para membros
  }
}


public class Main {
  public static void main(String[] args) {
    try(Scanner scanner = new Scanner(System.in)) {
      String discountType = scanner.next();
      double originalValue = scanner.nextDouble();
  
      // Aplicação OCP: Criando uma instância com base no tipo de desconto fornecido
      Discount discount = null; // Inicializa com null
  
      if ("student".equals(discountType)) {
          discount = new StudentDiscount();
      } else if ("membership".equals(discountType)) {
          discount = new MembershipDiscount();
      } else {
          System.out.println("Tipo de desconto inválido!");
          System.exit(1); // Encerra o programa
      }
  
      double discountValue = discount.calculateDiscount(originalValue);
      System.out.printf("%.2f", discountValue);
    }
  }
}
