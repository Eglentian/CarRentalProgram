package service;

import model.Shop;

import java.util.List;

public interface ShopService {

    void addShop(Shop shop);

    boolean updateShop(Shop shop);

    boolean deleteShop(Integer id);

    Shop getShopById(Integer id);

    List<Shop> getAllShops();

    void loginShop(String email, String password);

}
