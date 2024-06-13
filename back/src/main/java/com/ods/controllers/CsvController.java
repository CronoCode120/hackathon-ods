package com.ods.controllers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ods.dto.ListaTarjetasDTO;
import com.ods.dto.TarjetaDTO;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

@RestController
public class CsvController {

	private static final String CSV_FILE_CARDS = "./cards.csv";
	private static final String CSV_FILE_USERS = "./users.csv";

	@PostMapping("/addCards")
	public String addDataToCsv(@RequestBody List<String[]> data) {
		try (Writer writer = new FileWriter(CSV_FILE_CARDS)) {
			CSVWriter csvWriter = new CSVWriter(writer);

			// Escribir los datos al archivo CSV
			csvWriter.writeAll(data);
			csvWriter.close();

			return "Datos añadidos correctamente al archivo CSV.";
		} catch (IOException e) {
			e.printStackTrace();
			return "Error al añadir datos al archivo CSV: " + e.getMessage();
		}
	}
	
	@GetMapping("/addOneCard")
	public String addEntryToCsv(@RequestParam String question, @RequestParam String answer) {
		String[] newEntry = {question, answer};
		try (Writer writer = new FileWriter(CSV_FILE_CARDS, true); // Abrir en modo append
				CSVWriter csvWriter = new CSVWriter(writer)) {
			// Escribir la nueva entrada al archivo CSV
			csvWriter.writeNext(newEntry);
			return "Nueva entrada añadida correctamente al archivo CSV.";
		} catch (IOException e) {
			e.printStackTrace();
			return "Error al añadir la nueva entrada al archivo CSV: " + e.getMessage();
		}
	}
	
	@GetMapping("/addUsers")
	public String addUsers(@RequestParam String user, @RequestParam String password) {
		try (Writer writer = new FileWriter(CSV_FILE_USERS)) {
			String[] newEntry = {user, password};
			CSVWriter csvWriter = new CSVWriter(writer);

			csvWriter.writeNext(newEntry);
			csvWriter.close();

			return "Datos añadidos correctamente al archivo CSV.";
		} catch (IOException e) {
			e.printStackTrace();
			return "Error al añadir datos al archivo CSV: " + e.getMessage();
		}
	}
	
	@GetMapping("/listQuestions")
	public String listCards () {
		try (FileReader reader = new FileReader(CSV_FILE_USERS)) {
			CSVReader csvReader = new CSVReader(reader);
			List<TarjetaDTO> tarjetas = new ArrayList<>(); 
			TarjetaDTO card= new TarjetaDTO();
			for (String[] tarjeta : csvReader) {
				card = new TarjetaDTO(tarjeta[0],tarjeta[1]);
				tarjetas.add(card);
			}
			csvReader.close();

			ListaTarjetasDTO baraja = (ListaTarjetasDTO) tarjetas;
			
			return baraja.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "Error al añadir datos al archivo CSV: " + e.getMessage();
		}
	}
	
	
	
}

