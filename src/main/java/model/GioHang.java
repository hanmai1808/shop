package model;

import java.util.TreeMap;

public class GioHang {
	private TreeMap<SanPham, Integer> list;
	private long cartID;

	public GioHang() {

		list = new TreeMap<>();
		cartID = System.currentTimeMillis();
		// TODO Auto-generated constructor stub
	}

	public GioHang(TreeMap<SanPham, Integer> list, long cartID) {
		super();
		this.list = list;
		this.cartID = cartID;
	}

	public TreeMap<SanPham, Integer> getList() {
		return list;
	}

	public void setList(TreeMap<SanPham, Integer> list) {
		this.list = list;
	}

	public long getCartID() {
		return cartID;
	}

	public void setCartID(long cartID) {
		this.cartID = cartID;
	}

	public void addToCart(SanPham sp, int so_luong) {
		boolean bln = list.containsKey(sp);
		if (bln) {
			int sl = list.get(sp);
			so_luong += sl;
			list.put(sp, so_luong);
		} else {
			list.put(sp, so_luong);
		}

	}

	public void subToCart(SanPham sp, int so_luong) {
		boolean bln = list.containsKey(sp);
		if (bln) {
			int sl = list.get(sp);
			so_luong = sl - so_luong;
			if (so_luong <= 0) {
				list.remove(sp);
			} else {
				list.remove(sp);
				list.put(sp, so_luong);
			}

		}
	}
	public void removeToCart(SanPham sp) {
		boolean bln = list.containsKey(sp);
		if (bln) {
				list.remove(sp);

		}
	}
}
