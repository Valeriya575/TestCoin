export class Wallet {
	
	id: string;
	idUser: string;
	coin_token: string;
	countTimeStamp: Date;
	

	constructor(){
		
		this.id="";
		this.idUser="";
		this.coin_token="";
		this.countTimeStamp= new Date();
		
	}
}
