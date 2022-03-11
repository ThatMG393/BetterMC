/*
    Not to be confused with SimpleConfig in github

    This is custom made!
    Not optimized and probably slow
*/

package thatmg393.bt.mc.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;

import net.fabricmc.loader.api.FabricLoader;
import thatmg393.bt.mc.BTMC;

public class SimpleConfig {

    //private static String fullCFP;
    private static File cFile;
    private static JSONObject jObj = new JSONObject();


    /** Initializes ModC.
     * 
     *
     * @param fname Config file name
     * 
     */
    public SimpleConfig(String fname)
    {
        Path cfdir = FabricLoader.getInstance().getConfigDir();

        try
        {
            cFile = new File(cfdir + "//" + fname + ".json");
            if (cFile.createNewFile())
            {
                BTMC.LOGGER.info("Config file created at: " + cfdir + "/" + fname);
                //fullCFP = cfdir + "//" + fname + ".json";
            }
            else
            {
                BTMC.LOGGER.info("Config file already exists at: " + cfdir + "/" + fname);
                //fullCFP = cfdir + "//" + fname + ".json";
            }
        }
        catch (IOException ioe)
        {
            BTMC.LOGGER.error(ioe);
        }
    }

    /**
     * Get's the key in the config file and returns its value
     * 
     * @param key Name of the key
     * @param ctype Can be i, d, s, b, f, l
     * 
     * @return value corresponding to the given key otherwise null
     */
    public Object getKey(String key, CType ctype)
    {
        try
        {
            String Jcontent = new String(Files.readAllBytes(Paths.get(cFile.toURI())));
            JSONObject json = new JSONObject(Jcontent);
            
            if (ctype == CType.i)
            {
                return json.getInt(key);
            }
            else if (ctype == CType.d)
            {
                return json.getDouble(key);
            }
            else if (ctype == CType.s)
            {
                return json.getString(key);
            }
            else if (ctype == CType.b)
            {
                return json.getBoolean(key);
            }
            else if (ctype == CType.f)
            {
                return json.getFloat(key);
            }
            else if (ctype == CType.l)
            {
                return json.getLong(key);
            }
            else
            {
                throw new IndexOutOfBoundsException(ctype.toString() + " is invalid!");
            }
        }
        catch (IOException ioe)
        {
            BTMC.LOGGER.error(ioe);
            return null;
        }
        catch (JSONException je)
        {
            BTMC.LOGGER.error(je);
            return null;
        }
        catch (IndexOutOfBoundsException ioobe)
        {
            BTMC.LOGGER.error(ioobe);
            return null;
        }
    }

    /** Changes the key value
     * 
     * @param key Name of the object
     * @param value Replace current value with the given value
     * 
     * @return true if successful otherwise false
     */

    public boolean setKey(String key, String value)
    {
        try 
        {
            PrintWriter cF = new PrintWriter(cFile);

            //String s = "{" + "\"" + key + "\": \"" + value + "\"}" ;

            jObj.put(key, value);

            cF.println(jObj.toString(4));
            cF.close();
            return true;
        } catch (FileNotFoundException e) {
            BTMC.LOGGER.error(e);
            return false;
        }
        catch (NullPointerException npe) {
            npe.printStackTrace();
            return false;
        }
    }

    /** Changes the key value
     * 
     * @param key Name of the object
     * @param value Replace current value with the given value
     * 
     * @return true if successful otherwise false
     */

    public static boolean setKey(String key, boolean value)
    {
        try 
        {
            PrintWriter cF = new PrintWriter(cFile);

            //String s = "{" + "\"" + key + "\": \"" + value + "\"}" ;

            jObj.put(key, value);

            cF.println(jObj.toString(4));
            cF.close();
            return true;
        } catch (FileNotFoundException e) {
            BTMC.LOGGER.error(e);
            return false;
        }
        catch (NullPointerException npe) {
            npe.printStackTrace();
            return false;
        }
    }

    /** Changes the key value
     * 
     * @param key Name of the object
     * @param value Replace current value with the given value
     * 
     * @return true if successful otherwise false
     */

    public static boolean setKey(String key, int value)
    {
        try 
        {
            PrintWriter cF = new PrintWriter(cFile);

            //String s = "{" + "\"" + key + "\": \"" + value + "\"}" ;

            jObj.put(key, value);

            cF.println(jObj.toString(4));
            cF.close();
            return true;
        } catch (FileNotFoundException e) {
            BTMC.LOGGER.error(e);
            return false;
        }
        catch (NullPointerException npe) {
            npe.printStackTrace();
            return false;
        }
    }

    /** Changes the key value
     * 
     * @param key Name of the object
     * @param value Replace current value with the given value
     * 
     * @return true if successful otherwise false
     */

    public static boolean setKey(String key, float value)
    {
        try 
        {
            PrintWriter cF = new PrintWriter(cFile);

            //String s = "{" + "\"" + key + "\": \"" + value + "\"}" ;

            jObj.put(key, value);

            cF.println(jObj.toString(4));
            cF.close();
            return true;
        } catch (FileNotFoundException e) {
            BTMC.LOGGER.error(e);
            return false;
        }
        catch (NullPointerException npe) {
            npe.printStackTrace();
            return false;
        }
    }

    /** Changes the key value
     * 
     * @param key Name of the object
     * @param value Replace current value with the given value
     * 
     * @return true if successful otherwise false
     */

    public static boolean setKey(String key, double value)
    {
        try 
        {
            PrintWriter cF = new PrintWriter(cFile);

            //String s = "{" + "\"" + key + "\": \"" + value + "\"}" ;

            jObj.put(key, value);

            cF.println(jObj.toString(4));
            cF.close();
            return true;
        } catch (FileNotFoundException e) {
            BTMC.LOGGER.error(e);
            return false;
        }
        catch (NullPointerException npe) {
            npe.printStackTrace();
            return false;
        }
    }

    /** Changes the key value
     * 
     * @param key Name of the object
     * @param value Replace current value with the given value
     * 
     * @return true if successful otherwise false
     */

    public static boolean setKey(String key, long value)
    {
        try 
        {
            PrintWriter cF = new PrintWriter(cFile);

            //String s = "{" + "\"" + key + "\": \"" + value + "\"}" ;

            jObj.put(key, value);

            cF.println(jObj.toString(4));
            cF.close();
            return true;
        } catch (FileNotFoundException e) {
            BTMC.LOGGER.error(e);
            return false;
        }
        catch (NullPointerException npe) {
            npe.printStackTrace();
            return false;
        }
    }

    /** Adds key into the config file
     * 
     * @param key The name of the JSONObject
     * @param value The value of the key can be an int, boolean, double, string, long, and float
     * 
     * @return true if key is successfully in the config fileo therwise false
     */

    public boolean addKey(String key, String value)
    {
        try 
        {
            PrintWriter cF = new PrintWriter(cFile);

            //String s = "{" + "\"" + key + "\": \"" + value + "\"}" ;

            jObj.append(key, value);

            cF.println(jObj.toString(4));
            cF.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch (NullPointerException npe) {
            npe.printStackTrace();
            return false;
        }
    }

    /** Adds key into the config file
     * 
     * @param key The name of the JSONObject
     * @param value The value of the key can be an int, boolean, double, string, long, and float
     * 
     * @return true if key is successfully in the config fileo therwise false
     */

    public boolean addKey(String key, int value)
    {
        try 
        {
            PrintWriter cF = new PrintWriter(cFile);

            //String s = "{" + "\"" + key + "\": \"" + value + "\"}" ;

            jObj.append(key, value);

            cF.println(jObj.toString(4));
            cF.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch (NullPointerException npe) {
            npe.printStackTrace();
            return false;
        }
    }

    /** Adds key into the config file
     * 
     * @param key The name of the JSONObject
     * @param value The value of the key can be an int, boolean, double, string, long, and float
     * 
     * @return true if key is successfully in the config fileo therwise false
     */

    public boolean addKey(String key, boolean value)
    {
        try 
        {
            PrintWriter cF = new PrintWriter(cFile);

            //String s = "{" + "\"" + key + "\": \"" + value + "\"}" ;

            jObj.append(key, value);

            cF.println(jObj.toString(4));
            cF.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch (NullPointerException npe) {
            npe.printStackTrace();
            return false;
        }
    }

    /** Adds key into the config file
     * 
     * @param key The name of the JSONObject
     * @param value The value of the key can be an int, boolean, double, string, long, and float
     * 
     * @return true if key is successfully in the config fileo therwise false
     */

    public boolean addKey(String key, double value)
    {
        try 
        {
            PrintWriter cF = new PrintWriter(cFile);

            //String s = "{" + "\"" + key + "\": \"" + value + "\"}" ;

            jObj.append(key, value);

            cF.println(jObj.toString(4));
            cF.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch (NullPointerException npe) {
            npe.printStackTrace();
            return false;
        }
    }

    /** Adds key into the config file
     * 
     * @param key The name of the JSONObject
     * @param value The value of the key can be an int, boolean, double, string, long, and float
     * 
     * @return true if key is successfully in the config fileo therwise false
     */

    public boolean addKey(String key, float value)
    {
        try 
        {
            PrintWriter cF = new PrintWriter(cFile);

            //String s = "{" + "\"" + key + "\": \"" + value + "\"}" ;

            jObj.append(key, value);

            cF.println(jObj.toString(4));
            cF.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch (NullPointerException npe) {
            npe.printStackTrace();
            return false;
        }
    }

    /** Adds key into the config file
     * 
     * @param key The name of the JSONObject
     * @param value The value of the key can be an int, boolean, double, string, long, and float
     * 
     * @return true if key is successfully in the config fileo therwise false
     */

    public boolean addKey(String key, long value)
    {
        try 
        {
            PrintWriter cF = new PrintWriter(cFile);

            //String s = "{" + "\"" + key + "\": \"" + value + "\"}" ;

            jObj.append(key, value);

            cF.println(jObj.toString(4));
            cF.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch (NullPointerException npe) {
            npe.printStackTrace();
            return false;
        }
    }

    

    /*
        i is interger
        d is dobule
        s is string
        b is boolean
        f is float
        l is long
    */
    public enum CType {
        i,
        d,
        s,
        b,
        f,
        l
    }
}
