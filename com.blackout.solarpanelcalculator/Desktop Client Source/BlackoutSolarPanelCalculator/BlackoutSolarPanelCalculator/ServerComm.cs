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
            double[] valueArray = new double[11];
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
    }
}
