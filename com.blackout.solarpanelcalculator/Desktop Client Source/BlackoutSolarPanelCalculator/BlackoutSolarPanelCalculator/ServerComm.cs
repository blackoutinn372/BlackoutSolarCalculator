using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Net;
using System.Text;

namespace BlackoutSolarPanelCalculator {
    public static class ServerComm {

        public static double[] GetSolarGeneFormulaForAllMonths(string url, double[] monthIrradiance, double systemSize, double roofEfficiency, double inverterEfficiency, double wiringEfficiency, double whatYear, double agingEfficiencyLoss) {

            const string methodParameter = "desktop?method=getSolarGeneFormulaForAllMonths";
            string valueParameters = "";

            valueParameters += "&jan=" + monthIrradiance[0].ToString();
            valueParameters += "&feb=" + monthIrradiance[1].ToString();
            valueParameters += "&mar=" + monthIrradiance[2].ToString();
            valueParameters += "&apr=" + monthIrradiance[3].ToString();
            valueParameters += "&may=" + monthIrradiance[4].ToString();
            valueParameters += "&jun=" + monthIrradiance[5].ToString();
            valueParameters += "&jul=" + monthIrradiance[6].ToString();
            valueParameters += "&aug=" + monthIrradiance[7].ToString();
            valueParameters += "&sep=" + monthIrradiance[8].ToString();
            valueParameters += "&oct=" + monthIrradiance[9].ToString();
            valueParameters += "&nov=" + monthIrradiance[10].ToString();
            valueParameters += "&dec=" + monthIrradiance[11].ToString();
            valueParameters += "&systemSize=" + systemSize.ToString();
            valueParameters += "&roofEfficiency=" + roofEfficiency.ToString();
            valueParameters += "&inverterEfficiency=" + inverterEfficiency.ToString();
            valueParameters += "&wiringEfficiency=" + wiringEfficiency.ToString();
            valueParameters += "&whatYear=" + whatYear.ToString();
            valueParameters += "&agingEfficiencyLoss=" + agingEfficiencyLoss.ToString();

            WebRequest webReq = WebRequest.Create(url + methodParameter + valueParameters);
            Stream respStream = webReq.GetResponse().GetResponseStream();
            string responseString;

            using (StreamReader reader = new StreamReader(respStream)) {
                responseString = reader.ReadToEnd();
            }

            string[] responseStringArray = responseString.Split('~');
            double[] valueArray = new double[12];
            for (int i = 0; i < valueArray.Length; i++) {
                valueArray[i] = double.Parse(responseStringArray[i]);
            }

            return valueArray;
        }

        public static double GetEfficiencyForAngleAndDirection(string url, int directionIndex, int angleIndex) {
            
            const string methodParameter = "desktop?method=getEfficiencyForAngleAndDirection";
            string valueParameters = "";

            valueParameters += "&directionIndex=" + directionIndex;
            valueParameters += "&angleIndex=" + angleIndex;

            WebRequest webReq = WebRequest.Create(url + methodParameter + valueParameters);
            Stream respStream = webReq.GetResponse().GetResponseStream();
            string responseString;

            using (StreamReader reader = new StreamReader(respStream)) {
                responseString = reader.ReadToEnd();
            }

            return double.Parse(responseString);
        }

        public static string[] GetCityList(string url, int postcode) {

            const string methodParameter = "desktop?method=getCityList";
            string valueParameters = "";

            valueParameters += "&postcode=" +postcode.ToString();

            WebRequest webReq = WebRequest.Create(url + methodParameter + valueParameters);
            Stream respStream = webReq.GetResponse().GetResponseStream();
            string responseString;

            using (StreamReader reader = new StreamReader(respStream)) {
                responseString = reader.ReadToEnd();
            }

            string[] responseStringArray = responseString.Split('~');

            return responseStringArray;
        }

        public static double[] GetCity(string url, int cityIndex) {

            const string methodParameter = "desktop?method=getCity";
            string valueParameters = "";

            valueParameters += "&cityIndex=" + cityIndex.ToString();

            WebRequest webReq = WebRequest.Create(url + methodParameter + valueParameters);
            Stream respStream = webReq.GetResponse().GetResponseStream();
            string responseString;

            using (StreamReader reader = new StreamReader(respStream)) {
                responseString = reader.ReadToEnd();
            }

            string[] responseStringArray = responseString.Split('~');
            double[] valueArray = new double[19];
            for (int i = 0; i < valueArray.Length; i++) {
                valueArray[i] = double.Parse(responseStringArray[i]);
            }

            /*
             * 0 FeedInTariff
             * 1 ElectricityCost
             * 2 Postcode
             * 3 OptimalYearDegree
             * 4 BestWinterDegree
             * 5 BestSummerDegree
             * 6 JanIrr
             * 7 FebIrr
             * 8 MarIrr
             * 9 AprIrr
             * 10 MayIrr
             * 11 JunIrr
             * 12 JulIrr
             * 13 AugIrr
             * 14 SepIrr
             * 15 OctIrr
             * 16 NovIrr
             * 17 DecIrr
             * 18 AvgIrr
            */

            return valueArray;
        }

        public static double GetPowerConsumption(string url, string usageType, int householdSize) {

            const string methodParameter = "desktop?method=getPowerConsumption";
            string valueParameters = "";

            valueParameters += "&householdSize=" + householdSize.ToString();
            valueParameters += "&usageType=" + usageType;

            WebRequest webReq = WebRequest.Create(url + methodParameter + valueParameters);
            Stream respStream = webReq.GetResponse().GetResponseStream();
            string responseString;

            using (StreamReader reader = new StreamReader(respStream)) {
                responseString = reader.ReadToEnd();
            }

            return double.Parse(responseString);
        }

        public static string[] GetAggregateSavingsData(string url, double systemCost, double dailyGeneration, int cityIndex, double replacePercent, double agingEfficiencyLoss, double lifeSpan, double yearsToCalculate) {

            const string methodParameter = "desktop?method=getAggregateSavingsData";
            string valueParameters = "";

            valueParameters += "&systemCost=" + systemCost.ToString();
            valueParameters += "&dailyGeneration=" + dailyGeneration.ToString();
            valueParameters += "&cityIndex=" + cityIndex.ToString();
            valueParameters += "&replacePercent=" + replacePercent.ToString();
            valueParameters += "&agingEfficiencyloss=" + agingEfficiencyLoss.ToString();
            valueParameters += "&lifeSpan=" + lifeSpan.ToString();
            valueParameters += "&yearsToCalculate=" + yearsToCalculate.ToString();

            WebRequest webReq = WebRequest.Create(url + methodParameter + valueParameters);
            Stream respStream = webReq.GetResponse().GetResponseStream();
            string responseString;

            using (StreamReader reader = new StreamReader(respStream)) {
                responseString = reader.ReadToEnd();
            }

            string[] responseStringArray = responseString.Split('~');

            /*
             * 0 Estimated Daily Savings
             * 1-n Chart data
            */

            return responseStringArray;
        }
    }
}
