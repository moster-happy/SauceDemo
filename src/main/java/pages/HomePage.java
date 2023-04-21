package pages;

import WebKeywords.WebKeywords;
import io.qameta.allure.Step;
import items.Item;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import utils.log.LogHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomePage {
    private static Logger logger = LogHelper.getLogger();
    public WebKeywords action;
    private Item item;
    List<WebElement> els = new ArrayList<WebElement>();
    List<Item> listItems = new ArrayList<>();
    Comparator<Item> comparator = Comparator.comparing(Item::getChange);

    private String GROUP_CHANGE_ITEMS = "//div[@id='pills-active']//tr/td[3]";
    private String GROUP_CODE_ITEMS = "//div[@id='pills-active']//tr/td[1]";
    private String GROUP_NAME_ITEMS = "//div[@id='pills-active']//tbody/tr/th";
    private String GROUP_VOL_ITEMS = "//div[@id='pills-active']//tr/td[4]";

    public HomePage(WebKeywords action){
        this.action = action;
    }

    @Step("Get group items")
    public void getGroupItems(){
        els = action.findWebElements(GROUP_CHANGE_ITEMS);
        int count =0 ;
        List<WebElement> codeItems = action.findWebElements(GROUP_CODE_ITEMS);
        List<WebElement> nameItems = action.findWebElements(GROUP_NAME_ITEMS);
        List<WebElement> changeItems = action.findWebElements(GROUP_CHANGE_ITEMS);
        List<WebElement> volItems = action.findWebElements(GROUP_VOL_ITEMS);

        action.scrollToElement(GROUP_CHANGE_ITEMS);
        for(int i = 0; i <els.size() ; i++) {
            count++;
            float change = 0;
            String name = action.getText(nameItems.get(i));
            String code = action.getText(codeItems.get(i));
            String vol = action.getText(volItems.get(i));
            String txtChange = action.getText(changeItems.get(i));

            if(txtChange.contains(".")){
                try {
                    change = Float.parseFloat(txtChange);
                }catch(Exception e){
                    logger.error("Cannot parse ''{0}'' to float. Root cause is: ''{1}''", txtChange, e.getMessage());
                }
            }
            else{
                change = 0 ;
            }

            item = new Item(count, name, code, change, txtChange, vol);
            listItems.add(item);
        }
        action.takeScreenshot();
    }

    @Step("Descending order of change")
    public void descendItem(){
        Collections.sort(listItems, comparator);
        Collections.reverse(listItems);
        action.takeScreenshot();
        System.out.println(listItems);
    }
}
