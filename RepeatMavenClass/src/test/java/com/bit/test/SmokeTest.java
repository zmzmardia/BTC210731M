package com.bit.test;

import org.junit.Test;

import pages.CartPage;
import pages.CirclePage;
import pages.GirlsShoesPage;
import pages.HomePage;
import pages.ShippingDetailsPage;
import pages.ShoeDetailsPage;
import pages.ShoesCatagoryPage;
import pages.SignInPage;

public class SmokeTest extends BaseTest{
	
	@Test
	public void buyShoesFromTarget() throws InterruptedException {
	 HomePage hm = new HomePage(dr);
		hm.typeOnSearchBox();
	GirlsShoesPage gs = hm.clickOnSearch().get();
	ShoesCatagoryPage sc = gs.clickOnGirls().get();
	ShoeDetailsPage sd = sc.clickOnAnyShoe().get();
	sd.selectQuantity(1);
	sd.selectColor("Black");
	sd.selectSize(12);
	CartPage c = sd.clickOnCart().get();
	c.compareQntAndPrice(1);
	SignInPage sp = c.clickOnCheckOut().get();
	sp.SignIn("we can't find your account");
	CirclePage cp= sp.creatAccount().get();
	ShippingDetailsPage sdp = cp.clickOnSkip().get();
	sdp.addressDetails();
	sdp.cardDetailsAndPlaceOrder();
  }

}
