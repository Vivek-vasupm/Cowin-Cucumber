Feature: Getting Vaccinated Certificate 

Scenario: User want to sign-in to the Co-Win Application 

			Given User launch the Co-Win Application 
			When User Enter the Valid Mobile Number 
			Then User Validate the Mobile NUmber by getting OTP 
			And User Enter the OTP rececived in given mobile number 
			Then User validate the OTP by clicking Verify OTP TAB 
			
Scenario: User want to download the vaccinated Certificate
 
			Given User now in login page of Co-Win Application 
			When User Click on the Certificate Tab of first Dose 
			Then the vaccinatted Certificate starts to download. 
