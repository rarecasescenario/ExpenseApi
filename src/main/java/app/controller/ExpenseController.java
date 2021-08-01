package app.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import app.model.Expense;
import app.model.Expenses;
import app.model.Stores;
import app.model.T2Codes;
import app.service.ExpensesService;
import app.utils.AppErrortype;

@RestController
@RequestMapping("/api")
public class ExpenseController<Expenses> {

	private static final Log LOG = LogFactory.getLog(ExpenseController.class);
	
	@Autowired
	ExpensesService expensesService;
	
	@RequestMapping(value = "/expenses", method = RequestMethod.GET)
	public List<Expenses> getExpenses() {
		return (List<Expenses>) expensesService.getExpenses();
	}
		
	@RequestMapping(value = "/expenses/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Expenses>> getExpensesById(@PathVariable("id") Long id) {
		List<Expenses> expenses = (List<Expenses>) expensesService.getExpenseById(id);
		if(expenses.isEmpty()) {
			return new ResponseEntity<List<Expenses>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Expenses>>(expenses, HttpStatus.OK);
//		return (List<Expenses>) expensesService.getExpenseById(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/expense")
	public void addExpense(@RequestBody Expense e) {
		expensesService.addExpense(e);
	}
	
	/** 
	 * Stores
	 */
	@RequestMapping(method=RequestMethod.GET, value="/stores")
	public ResponseEntity<List<Stores>> getAllStores() {
		List<Stores> ls = expensesService.getAllStores();
		return new ResponseEntity<List<Stores>>(ls, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/stores")
	public void addStore(@RequestBody Stores o) {
		expensesService.addStore(o);
	}
	
	/**
	 * T2 Codes
	 */
	@RequestMapping(method=RequestMethod.GET, value="/t2codes")
	public ResponseEntity<List<T2Codes>> getAllCodes() {
		List<T2Codes> ls = expensesService.getAllT2Codes();
		return new ResponseEntity<List<T2Codes>>(ls, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/t2codes/{id}", method = RequestMethod.GET)
	public ResponseEntity<T2Codes> getT2CodeById(@PathVariable("id") Integer id) {
		
		LOG.info("#81 T2Code GET: id = " + id);
		
		T2Codes code = expensesService.findByCode(id);
		if(code == null) {
			LOG.info("#85 T2Code GET: NOT_FOUND " + id);
			return new ResponseEntity<T2Codes>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<T2Codes>(code, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/t2codes", method=RequestMethod.POST)
	public ResponseEntity<?> t2codes(@RequestBody T2Codes o, UriComponentsBuilder ucb) {
		
		LOG.info("T2Code POST: " + o.getCode() + "  " + o.getCodeDescription());
		
		if(expensesService.isT2CodeExists(o)) {
			return new ResponseEntity(
					new AppErrortype("Unable to create. A code " + o.getCode() + " already exists"),
					HttpStatus.CONFLICT);
		}
		expensesService.addCode(o);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucb.path("/api/t2codes/{id}").buildAndExpand(o.getCode()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	
}
