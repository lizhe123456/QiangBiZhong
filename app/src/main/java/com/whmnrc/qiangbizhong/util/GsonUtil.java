/*
 *   Copyright (C)  2016 android@19code.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.whmnrc.qiangbizhong.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GsonUtil {


    public static String createGsonString(Object object) {
        Gson gson = new Gson();
        String gsonString = gson.toJson(object);
        return gsonString;
    }


    public static <T> T changeGsonToBean(String gsonString, Class<T> cls) {
        Gson gson = new Gson();
        T t = gson.fromJson(gsonString, cls);
        return t;
    }

    public static <T> List<T> changeGsonToList(String gsonString, Class<T> cls) {
        Gson gson = new Gson();
        List<T> mList = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(gsonString).getAsJsonArray();
        for (final JsonElement elem : array) {
            mList.add(gson.fromJson(elem, cls));
        }
        return mList;
    }

    public static List<Map<String, Object>> changeGsonToListMaps(String gsonString) {
        List<Map<String, Object>> list = null;
        Gson gson = new Gson();
        list = gson.fromJson(gsonString,
                new TypeToken<List<Map<String, Object>>>() {
                }.getType());

        return list;
    }

    /**
     * 把modelA对象的属性值赋值给bClass对象的属性。
     *
     * @param modelA
     * @param bClass
     * @param <T>
     * @return
     */
    public static <A, T> T modelAconvertoB(A modelA, Class<T> bClass) {
        try {
            Gson gson = new Gson();
            String gsonA = gson.toJson(modelA);
            T instanceB = gson.fromJson(gsonA, bClass);
            return instanceB;
        } catch (Exception e) {
            return null;
        }
    }
}
