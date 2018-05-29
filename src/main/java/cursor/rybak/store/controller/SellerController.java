package cursor.rybak.store.controller;

import cursor.rybak.store.model.Seller;
import cursor.rybak.store.repository.seller.SellerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sellers")
public class SellerController {

	private SellerRepository sellerRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public SellerController(SellerRepository sellerRepository,
							BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.sellerRepository = sellerRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/sign-up")
	public void signUp(@RequestBody Seller seller) {
		seller.setPassword(bCryptPasswordEncoder.encode(seller.getPassword()));
		sellerRepository.save(seller);
	}

	@GetMapping("/success-logout")
	public String logout() {
		return "Logout success!";
	}
}
