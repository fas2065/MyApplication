package com.rasco.myapp.myapplication;

import android.support.test.runner.AndroidJUnit4;

import com.rasco.myapp.myapplication.base.Colors;
import com.rasco.myapp.myapplication.db.DBHandler;
import com.rasco.myapp.myapplication.db.ColorsDB;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class DBColorsTest {

    private ColorsDB database;

    @Before
    public void setUp() throws Exception {
        getTargetContext().deleteDatabase(DBHandler.DATABASE_NAME);
        database = new ColorsDB(getTargetContext(), DBHandler.DATABASE_NAME, null, DBHandler.DB_VERSION);
    }

    @After
    public void tearDown() throws Exception {
        database.close();
    }

    @Test
    public void shouldAddUpdateDeleteProgram() throws Exception {
        database.addColors(createColors());

        List<Colors> colorsList = database.getAllColors();
        assertThat(colorsList.size(), is(1));
        Colors colors = colorsList.get(0);
        assertTrue(colors.getName().equals("Colors1"));
        assertTrue(colors.getColorOne().equals("#234567"));
        assertTrue(colors.getColorTwo().equals("#234567"));
        assertTrue(colors.getColorThree().equals("#234567"));


        colors.setName("Colors2");
        colors.setColorTwo("#234577");
        database.updateColors(colors);
        colorsList = database.getAllColors();
        assertThat(colorsList.size(), is(1));
        colors = colorsList.get(0);
        assertTrue(colors.getName().equals("Colors2"));
        assertTrue(colors.getColorTwo().equals("#234577"));

        database.deleteColors(colors);
        colorsList = database.getAllColors();
        assertThat(colorsList.size(), is(0));


    }

    private Colors createColors() {

        Colors colors = new Colors();
        colors.setName("Colors1");
        colors.setColorOne("#234567");
        colors.setColorTwo("#234567");
        colors.setColorThree("#234567");
        return colors;

    }
}
