package lk.sliit.onlinepaymentservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payment {

		private String name;
		private int id;
		private int amount;
		private String CrdTyp;
		private String bank;
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getCrdTyp() {
			return CrdTyp;
		}
		public void setCrdTyp(String crdTyp) {
			CrdTyp = crdTyp;
		}
		public String getBank() {
			return bank;
		}
		public void setBank(String bank) {
			this.bank = bank;
		}
		
		@Override
		public String toString() {
			return "Payment [name=" + name + ", id=" + id + ", amount=" + amount + ", CrdTyp=" + CrdTyp + ", bank="
					+ bank + "]";
		}
		
		
	
}
