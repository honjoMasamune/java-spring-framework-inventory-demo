## Sample Java Spring Framework Inventory Application Demo

*This is a demo showcasing a Java Spring Framework inventory application. The demo will start with five in-house parts and five products.*

After starting the application, browse to *http://localhost:8080/mainscreen*, to start the demo.

### Under the Parts section, you will be able to do the following:

* Search for parts
	
* Add an in-house part to the inventory
  * Set part name
  * Set price
  * Set current inventory
  * Set part ID
  * Set minimum inventory value
  * Set maximum inventory value
	
* Add an outsourced part to the inventory
  * Set part name
  * Set price
  * Set current inventory
  * Set company name
  * Set minimum inventory value
  * Set maximum inventory value
	
* Update existing in-house parts in the inventory
  * Change part name
  * Change price
  * Change current inventory
  * Change Part ID
  * Change minimum inventory value
  * Change maximum inventory value
	
* Update existing outsourced parts in the inventory
  * Change part name
  * Change price
  * Change current inventory
  * Change company name
  * Change minimum inventory value
  * Change maximum inventory value
  
* Delete a part
  * Suppose the part to be deleted is associated with a product. In that case, you cannot delete the part without first disassociating the part from the product.
  
* Part min and max value concerning current inventory
  * Suppose inventory drops below the minimum inventory value or goes above the maximum inventory value. In that case, the user will be warned to adjust the inventory to fit between the minimum and max values set.


### Under the Products Section, you will be able to do the following:

* Search for products

* Add a product to the inventory
	* Set product name
    * Set price
    * Set inventory

* Update existing products in the inventory
	* Change product name
	* Change price
	* Change inventory
	* Associate a part with the given product
	* Remove an associated part

* Delete a product
	* Suppose the product to be deleted has an associated part. In that case, you cannot delete the product without first disassociating the part from the product. 
