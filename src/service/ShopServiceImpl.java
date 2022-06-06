package service;

import main.Main;
import model.Shop;
import repository.ShopRepository;

import java.util.List;

public class ShopServiceImpl implements ShopService {

    ShopRepository shopRepository = new ShopRepository();

    @Override
    public void addShop(Shop shop) {
        shopRepository.createShop(shop);

    }

    @Override
    public boolean updateShop(Shop shop) {
        return shopRepository.updateShop(shop);
    }

    @Override
    public boolean deleteShop(Integer id) {
        return shopRepository.deleteShop(id);
    }

    @Override
    public Shop getShopById(Integer id) {
        return shopRepository.findShopById(id);
    }

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.getAllShops();
    }

    @Override
    public void loginShop(String email, String password) {
        Main.authUser = shopRepository.loginUser(email, password);
    }

}
