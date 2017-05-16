package desktoprestconsumer.controller;

import desktoprestconsumer.model.Rest.Person;
import desktoprestconsumer.model.Rest.PersonCoincidencesByDate;
import desktoprestconsumer.model.Rest.PersonWithCoincidences;
import org.springframework.http.*;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Dima on 11.05.2017.
 */
public class PersonsController {

    private final String TABLE = "persons";
    private final String WEB_SERVICE_URL = "http://188.166.160.168:8085/api";

    /**
     * Получение данных из базы.
     */

    // Получение рейтинга конкретной личности за указанный диапазон дат по указанному сайту.
    public ArrayList<PersonCoincidencesByDate> getPersonByDate(String firstDate, String lastDate, int site_id, int person_id) {
        RestTemplate restTemplate = new RestTemplate();
        PersonCoincidencesByDate[] persons;
        persons = restTemplate.getForObject(WEB_SERVICE_URL + "/" + TABLE +
                        "/{firstDate}/{lastDate}/{site_id}/{person_id}", PersonCoincidencesByDate[].class,
                firstDate, lastDate, String.valueOf(site_id), String.valueOf(person_id));

        return new ArrayList<>(Arrays.asList(persons));
    }

    // Получение всех личностей и их рейтинга по указанному сайту.

    public ArrayList<PersonWithCoincidences> getPersonsOnSite(int site_id) {
        RestTemplate restTemplate = new RestTemplate();
        PersonWithCoincidences[] persons;
        persons = restTemplate.getForObject(WEB_SERVICE_URL + "/" + TABLE +
                        "/{site_id}", PersonWithCoincidences[].class,
                String.valueOf(site_id));

        return new ArrayList<>(Arrays.asList(persons));
    }

    // Получение всех личностей из таблицы persons.

    // Не работает если в классе Person нет сеттеров или есть конструктор с параметрами
    public Person[] getAllPersons() {

        RestTemplate restTemplate = new RestTemplate();

        // Для примера - с  GsonHttpMessageConverter() не работает

//        restTemplate.setMessageConverters((Arrays.asList(new GsonHttpMessageConverter())));
//        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());

        Person[] persons = restTemplate.getForObject(WEB_SERVICE_URL + "/" + TABLE + "/", Person[].class);

        if (persons == null) {
            Person person = new Person();
            person.setId(0);
            person.setName("Пусто");
            Person[] noNames = {person};
            return noNames;
        }

        return persons;
    }

    /**
     * Отправка данных в базу (администрирование).
     */

    // Добавление личности в таблицу persons.
    public String addPerson(String name) {

        String request = "{\"name\":\"" + name + "\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(request, headers);
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.patchForObject(WEB_SERVICE_URL + "/" + TABLE, entity, String.class);
    }

}
