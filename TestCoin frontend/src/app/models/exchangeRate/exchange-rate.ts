export class ExchangeRate {
	
	id:string;
	excRateDate: Date;
	excRateEur: number;
	excRateUsd: number;
	excRateGbp: number;
	
	constructor(){
		
		this.id="";
		this.excRateEur=0.0;
		this.excRateUsd=0.0;
		this.excRateGbp=0.0;
		this.excRateDate=new Date();
		
	}
}
