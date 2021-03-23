package parser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

@SuppressWarnings("all")
public class Parser {
    private final String filePath;

    private Conference conference;
    private double conferenceNumber;
    private Date dateStart;
    private Date dateEnd;
    private String times;
    private String subject;
    private String group;
    private String lecturer;
    private String type;
    private double lengthInHours;
    private String format;
    private String room;

    public Parser(String filePath) {
        this.filePath = filePath;
        this.conferenceNumber = -1;
    }

    private void addUnixTimeFromDateAndTime(Date date, String hour, String minutes) {
        date.setTime((long) (date.getTime() +
                Integer.parseInt(hour) * 1e3 * 3600L +
                Integer.parseInt(minutes) * 1e3 * 60L));
    }

    private void deleteUnixTimeFromDateAndTime(Date date, String hour, String minutes) {
        date.setTime((long) (date.getTime() -
                Integer.parseInt(hour) * 1e3 * 3600L -
                Integer.parseInt(minutes) * 1e3 * 60L));
    }

    public Schedule parse() {
        Schedule schedule = new Schedule(filePath);
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            boolean firstRow = true;

            for (Row nextRow : firstSheet) {
                if (firstRow) {
                    firstRow = false;
                    continue;
                }

                Iterator<Cell> cellIterator = nextRow.cellIterator();


                double lastConference = conferenceNumber;
                double tmpConference = cellIterator.next().getNumericCellValue();
                conferenceNumber = tmpConference == 0 ? conferenceNumber : tmpConference;
                if (lastConference != conferenceNumber) {
                    if (lastConference != -1) {
                        schedule.getConferences().add(conference);
                    }
                    conference = new Conference((int) tmpConference);
                }
                dateStart = Optional.ofNullable(cellIterator.next().getDateCellValue()).orElse(dateStart);
                dateEnd = (Date) dateStart.clone();
                String tmpTimes = cellIterator.next().getStringCellValue();
                times = tmpTimes.equals("") ? "0.00-23.59" : tmpTimes;
                subject = cellIterator.next().getStringCellValue();
                group = cellIterator.next().getStringCellValue();
                lecturer = cellIterator.next().getStringCellValue();
                type = cellIterator.next().getStringCellValue();
                lengthInHours = cellIterator.next().getNumericCellValue();
                format = cellIterator.next().getStringCellValue();
                room = cellIterator.next().getStringCellValue();

                addUnixTimeFromDateAndTime(dateStart,
                        times.split("-")[0].split("\\.")[0],
                        times.split("-")[0].split("\\.")[1]);
                addUnixTimeFromDateAndTime(dateEnd,
                        times.split("-")[1].split("\\.")[0],
                        times.split("-")[1].split("\\.")[1]);

                Meeting newMeeting = new Meeting((int) conferenceNumber, dateStart, dateEnd,
                        subject, group, lecturer, type, (int) lengthInHours, format, room);

                conference.getMeetings().add(newMeeting);

                deleteUnixTimeFromDateAndTime(dateStart,
                        times.split("-")[0].split("\\.")[0],
                        times.split("-")[0].split("\\.")[1]);
                deleteUnixTimeFromDateAndTime(dateEnd,
                        times.split("-")[1].split("\\.")[0],
                        times.split("-")[1].split("\\.")[1]);
            }

            inputStream.close();
        } catch (IllegalStateException ignored) {
            schedule.getConferences().add(conference);
        } catch (Exception e) {
            System.out.println("WRONG EXCEL FORMAT FOR FILE: " + filePath);
            e.printStackTrace();
        }

        return schedule;
    }
}
