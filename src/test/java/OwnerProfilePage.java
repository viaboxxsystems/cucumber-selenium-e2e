////public class OwnerProfilePage extends page.PageObject{
////
////	private NewPetPage newPetPage;
////
////	@FindBy(xpath="//*[@id='pets']/div/div/button")
////	private WebElement addNewButton;
////
////
////	public void addNewPet(final String name, final String type){
////		waitFor(addNewButton).click();
////		waitABit(1000);
////		newPetPage.addPet(name, type);
////		newPetPage.saveChanges();
////	}
////
////
////	public void verifyNewPetAddition(int identifier,String name, String type){
////		getDriver().findElement(By.xpath("//*[@id='pets']//h3[@data-ng-bind='pet.name' and text()='"+name+"']"));
////	}
////
////}
//
//public class NewPetPage extends page.PageObject{
//
//
//	@FindBy(xpath="//*[@data-ng-model='currentPet.name']")
//	private WebElement nameField;
//
//	@FindBy(id="type")
//	private WebElement typeField;
//
//	@FindBy(xpath="//*[@id='petModal']//button[@data-target='#addPetSuccessModal']")
//	private WebElement saveButton;
//
//	@FindBy(xpath="//*[@id='addPetSuccessModal']//button[text()='Not Now']")
//	private WebElement notNowButton;
//
//	public void addPet(String name,String type){
//		nameField.sendKeys(name);
//		new Select(typeField).selectByValue(type);
//	}
//
//	public void saveChanges(){
//		saveButton.click();
//		waitABit(1000);
//		notNowButton.click();
//	}
//
//}