package steps.simple

import io.cucumber.examples.java.RpnCalculator
import io.cucumber.java.DataTableType
import io.cucumber.java.DocStringType
import io.cucumber.java.ParameterType
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions
import java.math.BigDecimal
import java.util.*
import java.util.function.Consumer
import java.util.stream.Collectors
import java.util.stream.Stream

class ShoppingSteps {
    private val calc = RpnCalculator()
    private var shoppingList: List<Grocery>? = null
    private var shopStock: List<Grocery>? = null
    private var groceriesPrice = 0
    @DataTableType
    fun defineGrocery(entry: Map<String, String>): Grocery {
        return Grocery(entry["name"], Price.fromString(entry["price"]))
    }

    @ParameterType(name = "amount", value = "\\d+\\.\\d+\\s[a-zA-Z]+")
    fun defineAmount(value: String): Amount {
        val arr = value.split("\\s".toRegex()).toTypedArray()
        return Amount(BigDecimal(arr[0]), Currency.getInstance(arr[1]))
    }

    @DocStringType(contentType = "shopping_list")
    fun defineShoppingList(docstring: String): List<Grocery> {
        return docstring.lines()
            .map { name: String? -> Grocery(name) }
    }

    @Given("the following groceries:")
    fun the_following_groceries(groceries: List<Grocery>) {
        for (grocery in groceries) {
            calc.push(grocery.price!!.value)
            calc.push("+")
        }
    }

    @When("I pay {amount}")
    fun i_pay(amount: Amount) {
        calc.push(amount.price)
        calc.push("-")
    }

    @Then("my change should be {}")
    fun my_change_should_be_(change: Int) {
        Assertions.assertEquals(-calc.value()!!.toInt(), change)
    }

    @Given("the following shopping list:")
    fun the_following_shopping_list(list: List<Grocery>?) {
        shoppingList = list
    }

    @Given("the shop has following groceries:")
    fun the_shop_has_following_groceries(shopStock: List<Grocery>?) {
        this.shopStock = shopStock
    }

    @When("I count shopping price")
    fun i_count_shopping_price() {
        shoppingList!!.forEach(Consumer { grocery: Grocery ->
            for (shopGrocery in shopStock!!) {
                if (grocery == shopGrocery) {
                    groceriesPrice += shopGrocery.price!!.value
                }
            }
        })
    }

    @Then("price would be {int}")
    fun price_would_be(totalPrice: Int) {
        Assertions.assertEquals(groceriesPrice, totalPrice)
    }

    class Grocery {
        var name: String?
        var price: Price? = null

        constructor(name: String?, price: Price) {
            this.name = name
            this.price = price
        }

        constructor(name: String?) {
            this.name = name
        }

        override fun equals(o: Any?): Boolean {
            if (this === o) return true
            if (o == null || javaClass != o.javaClass) return false
            val grocery = o as Grocery
            return name == grocery.name
        }
    }

    class Price(val value: Int) {

        companion object {
            fun fromString(value: String?): Price {
                return Price(value!!.toInt())
            }
        }

    }

    class Amount(val price: BigDecimal, val currency: Currency)
}