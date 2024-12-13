package com.example.RegistrationData.repositories;

import com.example.RegistrationData.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate template;

    //
    public PurchaseRepository(JdbcTemplate template) {
        this.template = template;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase(customerId, productName, price, quantity) VALUES (?, ?, ?, ?)";

        template.update(sql, purchase.getCustomerId(), purchase.getProductName(), purchase.getPrice(), purchase.getQuantity());

    }

    public void updatePurchase(Purchase purchase) {
        String sql = "Update purchase SET productName = ?, price = ?, quantity = ? WHERE purchaseId = ?";
        template.update(sql, purchase.getProductName(), purchase.getPrice(), purchase.getQuantity());
    }

    public void deletePurchase(Purchase purchase) {
        String sql = "DELETE FROM purchase WHERE purchaseId = ?";
        template.update(sql, purchase.getPurchaseId());
    }


    public List<Purchase> findAllPurchases() {

        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setPurchaseId(r.getInt("purchaseId"));
            rowObject.setCustomerId(r.getInt("customerId"));
            rowObject.setProductName(r.getString("productName"));
            rowObject.setPrice(r.getBigDecimal("price"));
            rowObject.setQuantity(r.getInt("quantity"));
            return rowObject;
        };

        return template.query(sql, purchaseRowMapper);
    }

    public List<Purchase> findAllPurchasesByCustomerName(String customerName) {
        String sql = "SELECT * FROM purchase p INNER JOIN customer c ON p.customerId = c.customerId WHERE c.customerName = ?";

        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setPurchaseId(r.getInt("purchaseId"));
            rowObject.setCustomerId(r.getInt("customerId"));
            rowObject.setProductName(r.getString("productName"));
            rowObject.setPrice(r.getBigDecimal("price"));
            rowObject.setQuantity(r.getInt("quantity"));
            return rowObject;
        };
        System.out.println(customerName);

        return template.query(sql, new String[] {customerName}, purchaseRowMapper);

    }

}
