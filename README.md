# day-22-homework
## now on day 23

orig:

* Generic DBTXResponse model, and separated StudentView model
* cruddy student api (create/read to add to db from uris) in addition to required gets

updates:

* ManyToOne city and state entities
* MappedSuperClass base model with:
	* primary key
	* created timestamp (automatic, too!)
	* last updated timestamp (automatic, too!)
	* table version column for denormalized records 
* cruddy api for each entity in addition to the required gets